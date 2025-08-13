package org.florisboard.docs.components.widgets

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.TagElement
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Ul
import org.w3c.dom.HTMLDetailsElement
import org.w3c.dom.HTMLElement

enum class Theme(val id: String, val icon: String) {
    AUTO(
        id = "auto",
        icon = "circle-half",
    ),
    LIGHT(
        id = "light",
        icon = "sun",
    ),
    DARK(
        id = "dark",
        icon = "moon",
    );
}

private const val THEME_ATTR_NAME = "data-theme"
private const val THEME_STORAGE_KEY = "theme"

@Composable
fun ThemeSwitcher() {
    var currentTheme by remember {
        val theme = document.documentElement?.getAttribute(THEME_ATTR_NAME)?.let { themeId ->
            Theme.entries.firstOrNull { it.id == themeId }
        } ?: Theme.AUTO
        mutableStateOf(theme)
    }
    var currentDetailsRef by remember { mutableStateOf<HTMLDetailsElement?>(null) }

    LaunchedEffect(currentTheme) {
        currentTheme.let { theme ->
            if (theme.id == "auto") {
                document.documentElement?.removeAttribute(THEME_ATTR_NAME)
            } else {
                document.documentElement?.setAttribute(THEME_ATTR_NAME, theme.id)
            }
            window.localStorage.setItem(THEME_STORAGE_KEY, theme.id)
        }
    }

    TagElement("details", {
        classes("dropdown", "theme-switcher")
        ref {
            currentDetailsRef = it
            onDispose {
                currentDetailsRef = null
            }
        }
    }) {
        TagElement<HTMLElement>("summary", null) {
            BootstrapIcon(currentTheme.icon)
        }
        Ul {
            Theme.entries.forEach { theme ->
                Li {
                    A(href = "#", attrs = {
                        onClick {
                            currentTheme = theme
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
