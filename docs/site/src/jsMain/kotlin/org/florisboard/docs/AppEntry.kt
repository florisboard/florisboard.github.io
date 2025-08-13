package org.florisboard.docs

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.core.KobwebApp

@App
@Composable
fun AppEntry(content: @Composable () -> Unit) {
    KobwebApp {
        ProvidePreferredTheme {
            content()
        }
    }
}
