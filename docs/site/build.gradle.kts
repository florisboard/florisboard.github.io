import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link
import kotlinx.html.script

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.kobwebx.markdown)
}

group = "org.florisboard.docs"

kobweb {
    app {
        index {
            interceptUrls {
                enableSelfHosting()
            }
            description.set("Powered by Kobweb")
            head.add {
                link {
                    rel = "stylesheet"
                    href = "https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0"
                }
                link {
                    rel = "stylesheet"
                    href = "https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.pumpkin.min.css"
                }
                link {
                    rel = "stylesheet"
                    href = "/assets/docs.css"
                }
                val highlightJsVersion = "11.11.1"
                link {
                    rel = "stylesheet"
                    href = "https://cdn.jsdelivr.net/gh/highlightjs/cdn-release@$highlightJsVersion/build/styles/a11y-light.min.css"
                }
                link {
                    rel = "stylesheet"
                    href = "https://cdn.jsdelivr.net/gh/highlightjs/cdn-release@$highlightJsVersion/build/styles/a11y-dark.min.css"
                }
                script {
                    src = "https://cdn.jsdelivr.net/gh/highlightjs/cdn-release@$highlightJsVersion/build/highlight.min.js"
                }
                script {
                    src = "https://cdn.jsdelivr.net/gh/highlightjs/cdn-release@$highlightJsVersion/build/languages/json.min.js"
                }
                script {
                    src = "https://cdn.jsdelivr.net/gh/highlightjs/cdn-release@$highlightJsVersion/build/languages/kotlin.min.js"
                }
            }
        }
    }
    markdown {
        defaultLayout = ".components.layouts.DocsLayout"
        handlers {
            code.set { codeBlock ->

                val language = "\"\"\"${codeBlock.info.escapeTripleQuotedText()}\"\"\""
                val text = "\"\"\"${codeBlock.literal.escapeTripleQuotedText()}\"\"\""
                "org.florisboard.docs.components.widgets.CodeBlock($language, $text)"
            }
        }
    }
}

kotlin {
    configAsKobwebApplication(moduleName = "florisboard-docs")

    sourceSets {
        jsMain.dependencies {
            implementation(libs.compose.foundation)
            implementation(libs.compose.html.core)
            implementation(libs.compose.runtime)
            implementation(libs.kobweb.core)
            implementation(libs.kobwebx.markdown)
        }
    }
}
