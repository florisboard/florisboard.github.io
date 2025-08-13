package org.florisboard.docs

import androidx.compose.runtime.*
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLLinkElement

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

val LocalPreferredTheme = compositionLocalOf<Pair<Theme, (Theme) -> Unit>> { Theme.AUTO to {} }

@Composable
fun ProvidePreferredTheme(content: @Composable () -> Unit) {
    val prismLightThemeLink = remember {
        document.head?.querySelector("#prism-light-theme") as? HTMLLinkElement
    }
    val prismDarkThemeLink = remember {
        document.head?.querySelector("#prism-dark-theme") as? HTMLLinkElement
    }

    val currentTheme = remember {
        val theme = window.localStorage.getItem(THEME_STORAGE_KEY)?.let { themeId ->
            Theme.entries.firstOrNull { it.id == themeId }
        } ?: Theme.AUTO
        mutableStateOf(theme)
    }

    LaunchedEffect(currentTheme.value) {
        currentTheme.value.let { theme ->
            window.localStorage.setItem(THEME_STORAGE_KEY, theme.id)
            document.documentElement?.let { documentElement ->
                when (theme) {
                    Theme.AUTO -> {
                        documentElement.removeAttribute(THEME_ATTR_NAME)
                        prismLightThemeLink?.media = "(prefers-color-scheme: light)"
                        prismDarkThemeLink?.media = "(prefers-color-scheme: dark)"
                    }
                    Theme.LIGHT -> {
                        documentElement.setAttribute(THEME_ATTR_NAME, theme.id)
                        prismLightThemeLink?.media = "all"
                        prismDarkThemeLink?.media = "not all"
                    }
                    Theme.DARK -> {
                        documentElement.setAttribute(THEME_ATTR_NAME, theme.id)
                        prismLightThemeLink?.media = "not all"
                        prismDarkThemeLink?.media = "all"
                    }
                }
            }
        }
    }

    CompositionLocalProvider(
        value = LocalPreferredTheme provides (currentTheme.value to { currentTheme.value = it }),
        content = content,
    )
}
