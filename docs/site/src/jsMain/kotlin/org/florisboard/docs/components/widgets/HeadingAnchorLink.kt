package org.florisboard.docs.components.widgets

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Text

@Composable
fun HeadingAnchorLink(href: String) {
    A(href, attrs = {
        tabIndex(-1)
    }) {
        Text("#")
    }
}
