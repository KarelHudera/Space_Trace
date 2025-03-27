package karel.hudera.spacetrace.presentation.ui.screens.settings

import SpaceTrace.composeApp.BuildConfig
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import karel.hudera.spacetrace.presentation.ui.common.bars.ActionAppBar
import karel.hudera.spacetrace.presentation.ui.theme.LocalThemeIsDark

class SettingsScreen : Screen {
    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        Scaffold(
            topBar = { ActionAppBar(title = "Settings") }
        ) { padding ->

            val isDarkState = LocalThemeIsDark.current
            val isDark by isDarkState

            Column(
                Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                // Option to toggle theme
                SettingOptionWithToggle(
                    title = "Dark Theme",
                    initialValue = isDark, // Change to true if dark mode is enabled by default
                    onToggle = { isChecked ->
                        isDarkState.value = isChecked // Update theme
                    }
                )

                // Option to toggle notifications
                SettingOptionWithToggle(
                    title = "Notifications",
                    initialValue = false, // Change based on user preferences
                    onToggle = { isChecked ->
                        // Handle notification toggle action here
                    }
                )

                // Spacer to push the copyright to the bottom
                Spacer(modifier = Modifier.weight(1f))

                // Copyright notice
                Text(
                    text = "Space Trace v${BuildConfig.APP_VERSION}\n" +
                            "Developed by:",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center
                )

                DevelopersList()

                Text(
                    text = "© 2025 Space Trace. All rights reserved.",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 16.dp)
                )

                Spacer(Modifier.height(82.dp))
            }
        }
    }
}

@Composable
fun SettingOptionWithToggle(
    title: String,
    initialValue: Boolean,
    onToggle: (Boolean) -> Unit
) {
    var isChecked by remember { mutableStateOf(initialValue) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium
            )

            Switch(
                checked = isChecked,
                onCheckedChange = { checked ->
                    isChecked = checked
                    onToggle(checked)
                }
            )
        }
    }
}

@Composable
fun DevelopersList() {
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier.fillMaxWidth().padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DeveloperName(
            name = "Karel Hudera",
            url = "https://github.com/KarelHudera",
            uriHandler = uriHandler
        )
        DeveloperName(
            name = "Tomáš Borek",
            url = "https://github.com/Resiniferatoxin123",
            uriHandler = uriHandler
        )
        DeveloperName(
            name = "Vojta Šlosar",
            url = "https://github.com/Vojtza",
            uriHandler = uriHandler
        )
        DeveloperName(
            name = "Nikola Spěšný",
            url = "https://github.com/artas1340",
            uriHandler = uriHandler
        )
        DeveloperName(
            name = "Štěpán Mikule",
            url = "https://github.com/stepanmik",
            uriHandler = uriHandler
        )
    }
}


@Composable
fun DeveloperName(name: String, url: String, uriHandler: UriHandler) {
    Text(
        text = name,
        style = TextStyle(
            fontSize = 12.sp,
            textDecoration = TextDecoration.Underline
        ),
        modifier = Modifier
            .clickable {
                uriHandler.openUri(url)
            }
            .padding(2.dp)
    )
}