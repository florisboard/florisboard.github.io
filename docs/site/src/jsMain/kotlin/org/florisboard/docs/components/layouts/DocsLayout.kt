package org.florisboard.docs.components.layouts

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.layout.Layout
import org.jetbrains.compose.web.dom.Text

@Layout
@Composable
fun DocsLayout(content: @Composable () -> Unit) {
    Text("LAYOUT HELLO")
    content()
}
