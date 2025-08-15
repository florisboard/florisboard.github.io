package org.florisboard.docs.components.widgets

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.dom.GenericTag
import org.florisboard.docs.LocalPreferredTheme
import org.florisboard.docs.Theme
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLDetailsElement

@Composable
fun ThemeSwitcher() {
    val (currentTheme, setCurrentTheme) = LocalPreferredTheme.current
    var currentDetailsRef by remember { mutableStateOf<HTMLDetailsElement?>(null) }

    GenericTag("details", attrs = {
        classes("dropdown", "theme-switcher")
        ref {
            currentDetailsRef = it
            onDispose {
                currentDetailsRef = null
            }
        }
    }) {
        GenericTag("summary") {
            BootstrapIcon(currentTheme.icon)
        }
        Ul {
            Theme.entries.forEach { theme ->
                Li {
                    A(href = "#", attrs = {
                        onClick {
                            setCurrentTheme(theme)
                            currentDetailsRef?.removeAttribute("open")
                        }
                    }) {
                        BootstrapIcon(theme.icon)
                        Span { Text(theme.id) }
                    }
                }
            }
        }
    }
}
