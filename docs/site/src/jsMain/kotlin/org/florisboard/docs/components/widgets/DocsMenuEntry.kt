package org.florisboard.docs.components.widgets

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.navigation.Anchor
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Li
import org.w3c.dom.HTMLAnchorElement

@Composable
fun DocsMenuEntry(href: String, level: Int, content: ContentBuilder<HTMLAnchorElement>) {
    val ctx = rememberPageContext()
    var isCurrentPage by remember { mutableStateOf(false) }

    LaunchedEffect(ctx.route.path) {
        isCurrentPage = href.removeSuffix("/") == ctx.route.path.removeSuffix("/")
    }

    Li(attrs = {
        attr("data-level", level.toString())
        if (isCurrentPage) {
            classes("current")
        }
    }) {
        Anchor(href, attrs = {
            classes("secondary")
            if (isCurrentPage) {
                attr("aria-current", "page")
            }
        }, content = content)
    }
}
