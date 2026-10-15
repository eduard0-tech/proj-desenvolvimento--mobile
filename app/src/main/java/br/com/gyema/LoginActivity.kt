package br.com.gyema

import android.app.Activity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.Toast

class LoginActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        setContentView(R.layout.activity_login)
        findViewById<View>(R.id.login_root).setOnApplyWindowInsetsListener { view, insets ->
            view.setPadding(insets.systemWindowInsetLeft, insets.systemWindowInsetTop,
                insets.systemWindowInsetRight, insets.systemWindowInsetBottom)
            insets
        }

        findViewById<View>(R.id.button_back).setOnClickListener { finish() }
        val email = findViewById<EditText>(R.id.input_email)
        val password = findViewById<EditText>(R.id.input_password)
        // Guarda somente a identificação solicitada, nunca a senha.
        val preferences = getSharedPreferences("login", MODE_PRIVATE)
        val rememberUser = findViewById<CheckBox>(R.id.checkbox_remember_user)
        if (savedInstanceState == null) {
            val rememberedEmail = preferences.getString("email", "").orEmpty()
            email.setText(rememberedEmail)
            rememberUser.isChecked = rememberedEmail.isNotEmpty()
        }
        rememberUser.setOnCheckedChangeListener { _, checked ->
            if (!checked) preferences.edit().remove("email").apply()
        }
        val visibility = findViewById<ImageButton>(R.id.button_password_visibility)
        visibility.setOnClickListener {
            val showPassword = password.transformationMethod is PasswordTransformationMethod
            val cursor = password.selectionStart.coerceAtLeast(0)
            password.transformationMethod = if (showPassword)
                HideReturnsTransformationMethod.getInstance() else PasswordTransformationMethod.getInstance()
            password.setSelection(cursor.coerceAtMost(password.length()))
            visibility.setImageResource(if (showPassword) R.drawable.ic_eye else R.drawable.ic_eye_off)
            visibility.contentDescription = getString(if (showPassword) R.string.hide_password else R.string.show_password)
        }
        fun submit() {
            email.error = null
            password.error = null
            when {
                !Patterns.EMAIL_ADDRESS.matcher(email.text.toString().trim()).matches() -> {
                    email.error = getString(R.string.invalid_email)
                    email.requestFocus()
                }
                password.text.isEmpty() -> {
                    password.error = getString(R.string.required_password)
                    password.requestFocus()
                }
                else -> {
                    if (rememberUser.isChecked) {
                        preferences.edit().putString("email", email.text.toString().trim()).apply()
                    }
                    Toast.makeText(this, R.string.authentication_pending, Toast.LENGTH_LONG).show()
                }
            }
        }
        findViewById<View>(R.id.button_submit_login).setOnClickListener { submit() }
        password.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) { submit(); true } else false
        }
        findViewById<View>(R.id.button_forgot_password).setOnClickListener {
            Toast.makeText(this, R.string.recovery_pending, Toast.LENGTH_SHORT).show()
        }
        findViewById<View>(R.id.button_login_register).setOnClickListener {
            Toast.makeText(this, R.string.registration_pending, Toast.LENGTH_SHORT).show()
        }
    }
}
