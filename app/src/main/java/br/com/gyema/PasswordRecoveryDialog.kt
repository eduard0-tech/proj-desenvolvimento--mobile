package br.com.gyema

import android.app.Dialog
import android.app.DialogFragment
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.content.Context
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

/** Local prototype flow; replace the transition with a successful API response when available. */
class PasswordRecoveryDialog : DialogFragment() {
    private var requested = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requested = savedInstanceState?.getBoolean("requested") ?: false
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val popup = Dialog(activity)
        popup.requestWindowFeature(Window.FEATURE_NO_TITLE)
        popup.setContentView(R.layout.dialog_password_recovery)
        popup.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        popup.window?.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        popup.window?.setDimAmount(0.65f)
        popup.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        val email = popup.findViewById<EditText>(R.id.input_recovery_email)
        val action = popup.findViewById<Button>(R.id.button_recovery_submit)
        fun render() {
            popup.findViewById<TextView>(R.id.recovery_title).setText(
                if (requested) R.string.recovery_success_title else R.string.recovery_title)
            popup.findViewById<TextView>(R.id.recovery_description).setText(
                if (requested) R.string.recovery_success_description else R.string.recovery_description)
            email.visibility = if (requested) View.GONE else View.VISIBLE
            action.setText(if (requested) R.string.return_to_login else R.string.request_recovery)
            popup.setTitle(getString(if (requested) R.string.recovery_success_title else R.string.recovery_title))
        }
        fun submit() {
            if (requested) {
                dismiss()
                return
            }
            email.error = null
            if (!Patterns.EMAIL_ADDRESS.matcher(email.text.toString().trim()).matches()) {
                email.error = getString(R.string.invalid_email)
                email.requestFocus()
                return
            }
            (activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                .hideSoftInputFromWindow(email.windowToken, 0)
            email.clearFocus()
            requested = true
            render()
            popup.findViewById<TextView>(R.id.recovery_title)
                .announceForAccessibility(getString(R.string.recovery_success_title))
        }
        action.setOnClickListener { submit() }
        email.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) { submit(); true } else false
        }
        render()
        return popup
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels - 48 * resources.displayMetrics.density)
            .toInt().coerceAtMost((360 * resources.displayMetrics.density).toInt())
        dialog.window?.setLayout(width, WindowManager.LayoutParams.WRAP_CONTENT)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("requested", requested)
    }
}
