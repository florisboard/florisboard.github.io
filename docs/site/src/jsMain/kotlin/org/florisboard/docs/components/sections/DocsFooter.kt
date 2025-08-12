package org.florisboard.docs.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.navigation.Anchor
import org.jetbrains.compose.web.dom.Footer
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun DocsFooter() {
    Footer(attrs = { classes("container") }) {
        P {
            Span {
                Text("© 2020-2025 ")
            }
            Anchor(href = "https://github.com/florisboard/florisboard/graphs/contributors") {
                Text("The FlorisBoard Contributors")
            }
        }
    }
}
