package org.florisboard.docs.components.widgets

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Code
import org.jetbrains.compose.web.dom.Text

@Composable
fun NoWrapCodeBlock(text: String) {
    Code(attrs = {
        classes("fl-nowrap")
    }) {
        Text(text)
    }
}
