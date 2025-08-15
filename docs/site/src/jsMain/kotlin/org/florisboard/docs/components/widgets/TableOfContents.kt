package org.florisboard.docs.components.widgets

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Aside
import org.jetbrains.compose.web.dom.B
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Ul

@Composable
fun TableOfContents(content: @Composable () -> Unit) {
    Aside(attrs = { id("table-of-contents") }) {
        Nav {
            Ul {
                Li { B { Text("On this page") } }
                content()
            }
        }
    }
}

@Composable
fun TableOfContentsEntry(
    anchor: String,
    text: String,
    level: Int,
) {
    Li(attrs = { attr("data-level", level.toString()) }) {
        A(href = anchor, attrs = { classes("secondary") }) {
            Text(text)
        }
    }
}
