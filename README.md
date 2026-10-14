# Gyema Academia Unifor

Projeto da disciplina de Desenvolvimento Mobile em Kotlin com Android Views e layouts XML.

## Abrir e editar

Abra a pasta raiz no Android Studio e aguarde a sincronização do Gradle. Use o JDK integrado (17 ou superior), Android SDK 37 e Build Tools 36.0.0. Execute o módulo `app` em Android 8.0 (API 26) ou superior.

Abra `app/src/main/res/layout/activity_main.xml` e selecione **Design** ou **Split** para editar os componentes visualmente. Textos e cores estão em `res/values`; imagens e fundos estão em `res/drawable`.

## Tela de login

O layout está em `app/src/main/res/layout/activity_login.xml` e o comportamento em `app/src/main/java/br/com/gyema/LoginActivity.kt`.

O botão de entrar das boas-vindas abre o login. A seta e o voltar do Android retornam à tela anterior. O formulário valida o formato do e-mail e a presença de senha, permite mostrar/ocultar a senha e lembrar apenas o e-mail no aparelho; senhas não são persistidas.

A autenticação e as telas de cadastro e recuperação ainda não foram implementadas. Seus botões na tela de login exibem avisos dessa etapa, sem simular uma sessão válida.

