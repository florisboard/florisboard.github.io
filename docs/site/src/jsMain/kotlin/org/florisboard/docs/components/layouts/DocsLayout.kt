package org.florisboard.docs.components.layouts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.core.PageContext
import com.varabyte.kobweb.core.layout.Layout
import com.varabyte.kobwebx.markdown.markdown
import kotlinx.browser.document
import org.florisboard.docs.components.sections.DocsFooter
import org.florisboard.docs.components.sections.DocsHeader
import org.florisboard.docs.components.sections.DocsMenu
import org.jetbrains.compose.web.dom.B
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Main
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Layout
@Composable
fun DocsLayout(ctx: PageContext, content: @Composable () -> Unit) {
    LaunchedEffect(ctx.route.path) {
        js("Prism.highlightAll()")
    }

    DocsHeader()

    Main(attrs = { classes("container-lg") }) {
        DocsMenu()
        Div(attrs = { id("content") }) {
            val title = ctx.markdown?.frontMatter?.query("title")?.scalarOrNull()
            if (title != null) {
                LaunchedEffect(title) {
                    document.title = title
                }
                H1 { Text(title) }
            }
            val appliesTo = ctx.markdown?.frontMatter?.query("applies_to")?.scalarOrNull()
            if (appliesTo != null) {
                P {
                    B { Text("Applies to: ") }
                    Span { Text(appliesTo) }
                }
            }
            content()
        }
    }

    DocsFooter()
}
