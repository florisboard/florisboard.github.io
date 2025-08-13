import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import com.varabyte.kobwebx.gradle.markdown.handlers.MarkdownHandlers
import com.varabyte.kobwebx.gradle.markdown.ext.kobwebcall.KobwebCall
import kotlinx.html.id
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
                    href = "https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css"
                }
                link {
                    rel = "stylesheet"
                    href = "https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.pumpkin.min.css"
                }
                link {
                    rel = "stylesheet"
                    href = "https://unpkg.com/automad-prism-themes@0.3.4/dist/prism-tokyo-night-light.css"
                    id = "prism-light-theme"
                    media = "(prefers-color-scheme: light)"
                }
                link {
                    rel = "stylesheet"
                    href = "https://unpkg.com/automad-prism-themes@0.3.4/dist/prism-tokyo-night.css"
                    id = "prism-dark-theme"
                    media = "(prefers-color-scheme: dark)"
                }
                script {
                    src = "/assets/prism.js"
                }
                link {
                    rel = "stylesheet"
                    href = "/assets/docs.css"
                }
            }
        }
    }
    markdown {
        defaultLayout = ".components.layouts.DocsLayout"
        handlers {
            a.set { link ->
                "com.varabyte.kobweb.navigation.Anchor(\"${link.destination}\")"
            }

            code.set { codeBlock ->
                val language = "\"\"\"${codeBlock.info.escapeTripleQuotedText()}\"\"\""
                val text = "\"\"\"${codeBlock.literal.escapeTripleQuotedText()}\"\"\""
                "org.florisboard.docs.components.widgets.CodeBlock($language, $text)"
            }

            inlineCode.set { inlineCode ->
                val text = "\"${inlineCode.literal.escapeSingleQuotedText()}\""
                "org.florisboard.docs.components.widgets.NoWrapCodeBlock($text)"
            }

            // Source: https://github.com/varabyte/kobweb-site/blob/79515be7b6b0db0b96e2072f33ded9fb616c5026/site/build.gradle.kts#L100-L113
            val baseHeadingHandler = heading.get()
            heading.set { heading ->
                val result = baseHeadingHandler.invoke(this, heading)
                val id = data.getValue(MarkdownHandlers.DataKeys.HeadingIds).getValue(heading)
                heading.appendChild(KobwebCall(".components.widgets.HeadingAnchorLink(\"#$id\")"))
                result
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
