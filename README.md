# Gyema — Academia Unifor

Projeto da disciplina de Desenvolvimento Mobile em Kotlin com Android Views e layouts XML.

## Abrir e editar

Abra a pasta raiz no Android Studio e aguarde a sincronização do Gradle. Use o JDK integrado (17 ou superior), Android SDK 37 e Build Tools 36.0.0. Execute o módulo `app` em Android 8.0 (API 26) ou superior.

Abra `app/src/main/res/layout/activity_main.xml` e selecione **Design** ou **Split** para editar os componentes visualmente. Textos e cores estão em `res/values`; imagens e fundos estão em `res/drawable`.

## Etapa atual

Tela de boas-vindas baseada na captura do protótipo. Os botões ainda não têm navegação; login, cadastro, documentos, suporte e sessão serão tratados na etapa de fluxo. O símbolo e os ornamentos são aproximações vetoriais; substituir pelas exportações originais do Figma quando disponíveis.

## Verificação

No Windows, execute `./gradlew.bat assembleDebug lintDebug`. O Android Gradle Plugin 9 inclui suporte a Kotlin.

## Desenvolvimento em computador com poucos recursos

O Gradle está limitado a 1 GB de heap e um worker, com compilação Kotlin no mesmo processo. Isso reduz a concorrência e o consumo de memória, mas pode aumentar o tempo de compilação.

Para trabalhar nos fluxos, use apenas Kotlin e XML. Não há bibliotecas externas de interface, Compose, banco de dados ou serviços de rede. O SDK 37 foi mantido porque já está instalado; trocar a plataforma agora exigiria outro download. Para testar, prefira um celular físico e mantenha o emulador fechado. Abra a prévia Design apenas quando precisar conferir a aparência.
