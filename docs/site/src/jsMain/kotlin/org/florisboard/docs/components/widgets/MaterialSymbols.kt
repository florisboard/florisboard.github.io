package org.florisboard.docs.components.widgets

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun MaterialSymbolsOutlined(name: String) {
    Span(attrs = { classes("material-symbols-outlined") }) {
        Text(name)
    }
}
