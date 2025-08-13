package org.florisboard.docs.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.width
import com.varabyte.kobweb.navigation.Anchor
import org.florisboard.docs.components.widgets.BootstrapIcon
import org.florisboard.docs.components.widgets.ThemeSwitcher
import org.jetbrains.compose.web.dom.*

@Composable
fun DocsHeader() {
    Header(attrs = { classes("container") }) {
        Nav {
            Ul {
                Li {
                    Anchor(href = "/", attrs = { classes("logo") }) {
                        Img(src = "/assets/images/Stable_RSquare.png", attrs = { width(48) })
                        B { Text("FlorisBoard Docs") }
                    }
                }
            }
            Ul {
                Li {
                    Anchor(href = "https://github.com/florisboard/florisboard", attrs = {
                        classes("social-icon")
                    }) {
                        BootstrapIcon("git")
                    }
                }
                Li {
                    ThemeSwitcher()
                }
            }
        }
    }
}
