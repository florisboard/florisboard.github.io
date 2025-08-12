package org.florisboard.docs.components.sections

import androidx.compose.runtime.Composable
import org.florisboard.docs.components.widgets.ThemeSwitcher
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Header
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Ul

@Composable
fun DocsHeader() {
    Header(attrs = { classes("container") }) {
        Nav {
            Ul {
                Li {
                    Text("FlorisBoard")
                }
            }
            Ul {
                Li {
                    ThemeSwitcher()
                }
            }
        }
    }
}
