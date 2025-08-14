package org.florisboard.docs.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.dom.RawHtml
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.navigation.Anchor
import org.jetbrains.compose.web.dom.Footer
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Small
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@OptIn(DelicateApi::class)
@Composable
fun DocsFooter() {
    Footer(attrs = { classes("container-lg") }) {
        P {
            Span {
                Text("© 2020-2025 ")
            }
            Anchor(href = "https://github.com/florisboard/florisboard/graphs/contributors") {
                Text("The FlorisBoard Contributors")
            }
        }
        P {
            Small {
                Text("Project licensed ")
                Anchor(href = "https://github.com/florisboard/florisboard/blob/main/LICENSE") {
                    Text("Apache License 2.0")
                }
                RawHtml("&nbsp;&nbsp;&#8226;&nbsp;&nbsp;")
                Text("Documentation licensed ")
                Anchor(href = "https://github.com/florisboard/florisboard.org/blob/main/LICENSE-CC-BY-SA-4.0") {
                    Text("CC BY-SA 4.0")
                }
                RawHtml("&nbsp;&nbsp;&#8226;&nbsp;&nbsp;")
                Text("Icons by ")
                Anchor(href = "https://icons.getbootstrap.com") {
                    Text("Bootstrap")
                }
            }
        }
    }
}
