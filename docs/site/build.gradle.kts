import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import com.varabyte.kobwebx.gradle.markdown.handlers.MarkdownHandlers
import com.varabyte.kobwebx.gradle.markdown.ext.kobwebcall.KobwebCall
import com.varabyte.kobweb.common.collect.Key
import com.varabyte.kobwebx.gradle.markdown.children
import kotlinx.html.id
import kotlinx.html.link
import kotlinx.html.script
import org.commonmark.node.Code
import org.commonmark.node.Node
import org.commonmark.node.Text

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

            // Base idea: https://github.com/varabyte/kobweb-site/blob/79515be7b6b0db0b96e2072f33ded9fb616c5026/site/build.gradle.kts#L100-L113
            val baseHeadingHandler = heading.get()
            heading.set { heading ->
                val result = baseHeadingHandler.invoke(this, heading)
                val anchor = data.getValue(MarkdownHandlers.DataKeys.HeadingIds).getValue(heading).let {
                    "#$it"
                }
                // Must make this a local fun else Gradle configuration cache screams at us
                fun nestedLiteral(node: Node): String = when (node) {
                    is Text -> node.literal
                    is Code -> node.literal
                    else -> node.children().joinToString { nestedLiteral(it) }
                }
                val text = nestedLiteral(heading)
                heading.appendChild(KobwebCall(".components.widgets.HeadingAnchorLink(\"$anchor\")"))
                val headingsMeta = TableOfContents.HeadingMeta(
                    anchor = anchor.escapeSingleQuotedText(),
                    text = text.escapeSingleQuotedText(),
                    level = heading.level,
                )
                val headingMetas = data.computeIfAbsent(TableOfContents.HeadingMetasKey) { mutableListOf() }
                headingMetas.add(headingsMeta)
                result
            }

            // Note: we use a custom HTML tag instead of KobwebCall because we want to statically build
            // the table of contents and not require JS for this
            val baseHtmlHandler = html.get()
            html.set { html ->
                val tag = html.literal
                if (tag.matches(TableOfContents.TagPattern)) {
                    val headingMetas = data[TableOfContents.HeadingMetasKey]
                    buildString {
                        appendLine("org.florisboard.docs.components.widgets.TableOfContents {")
                        headingMetas?.forEach { (anchor, text, level) ->
                            append("org.florisboard.docs.components.widgets.TableOfContentsEntry(")
                            append("anchor = \"$anchor\", ")
                            append("text = \"$text\", ")
                            append("level = $level")
                            appendLine(")")
                        }
                        appendLine("}")
                    }
                } else {
                    baseHtmlHandler.invoke(this, html)
                }
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

object TableOfContents {
    val HeadingMetasKey = let {
        // We need this due to incremental cache issues, else this key seems to get re-created with
        // the key already existing
        val time = System.currentTimeMillis().toString()
        Key.create<MutableList<HeadingMeta>>("fl.heading.metas.$time")
    }
    val TagPattern = "<table-of-contents.*/>".toRegex()

    data class HeadingMeta(
        val anchor: String,
        val text: String,
        val level: Int,
    )
}
