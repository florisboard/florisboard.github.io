package org.florisboard.docs.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.layout.Layout
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Page
@Layout(".components.layouts.DocsLayout")
@Composable
fun HomePage() {
    Span {
        Text("Hello text")
    }
}
