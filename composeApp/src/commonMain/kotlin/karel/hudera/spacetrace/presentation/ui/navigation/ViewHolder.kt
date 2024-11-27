package karel.hudera.spacetrace.presentation.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import org.jetbrains.compose.resources.painterResource
import spacetrace.composeapp.generated.resources.Res
import spacetrace.composeapp.generated.resources.globe_full
import spacetrace.composeapp.generated.resources.rocket_full
import spacetrace.composeapp.generated.resources.settings
import spacetrace.composeapp.generated.resources.settings_full

@Composable
fun ViewHolder() {
    TabNavigator(NewsTab) {
        Scaffold(
            content = { innerPadding ->
                Box(
                    modifier = Modifier
                        .padding(innerPadding),
                ) {
                    CurrentTab()
                }
            },
            bottomBar = {
                NavigationBar {
                    TabNavigationItem(NewsTab)
                    TabNavigationItem(RocketLaunchTab)
                    TabNavigationItem(SettingsTab)
                }
            }
        )
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    val isSelected = tabNavigator.current == tab

    NavigationBarItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = {
            tab.options.icon?.let {
                Icon(
                    painter = if (isSelected) {
                        FilledIcon(tab)
                    } else {
                        it
                    },
                    tint = if (isSelected) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.primary.copy(0.7f)
                    },
                    contentDescription = tab.options.title,
                    modifier = Modifier.size(20.dp)
                )
            }
        },

        label = {
            Text(
                text = tab.options.title,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                color = if (isSelected) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.primary.copy(alpha = 0.7f)
                }
            )
        }
    )
}

@Composable
fun FilledIcon(item: Tab) = when (item.options.index) {
    (0u).toUShort() -> painterResource(Res.drawable.globe_full)
    (1u).toUShort() -> painterResource(Res.drawable.rocket_full)
    (2u).toUShort() -> painterResource(Res.drawable.settings_full)
    else -> painterResource(Res.drawable.settings) // indicates error
}