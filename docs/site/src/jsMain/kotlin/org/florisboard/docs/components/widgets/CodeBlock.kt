package org.florisboard.docs.components.widgets

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Code
import org.jetbrains.compose.web.dom.Pre
import org.jetbrains.compose.web.dom.Text

@Composable
fun CodeBlock(language: String, text: String) {
    Pre {
        Code(attrs = {
            if (language.isNotBlank()) {
                classes("language-${language.trim()}")
            }
        }) {
            Text(text)
        }
    }
}
