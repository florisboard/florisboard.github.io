package org.florisboard.docs.components.layouts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.core.PageContext
import com.varabyte.kobweb.core.layout.Layout
import com.varabyte.kobwebx.markdown.markdown
import kotlinx.browser.document
import org.florisboard.docs.components.sections.DocsFooter
import org.florisboard.docs.components.sections.DocsHeader
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Main
import org.jetbrains.compose.web.dom.Text

@Layout
@Composable
fun DocsLayout(ctx: PageContext, content: @Composable () -> Unit) {
    LaunchedEffect(ctx.route.path) {
        js("hljs.highlightAll()")
    }

    DocsHeader()

    Main(attrs = { classes("container") }) {
        val title = ctx.markdown?.frontMatter?.getValue("title")?.singleOrNull()
        if (title != null) {
            LaunchedEffect(title) {
                document.title = title
            }
            H1 { Text(title) }
        }
        content()
    }

    DocsFooter()
}
