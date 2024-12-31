package karel.hudera.spacetrace.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import karel.hudera.spacetrace.presentation.ui.screens.settings.SettingsScreen
import org.jetbrains.compose.resources.painterResource
import spacetrace.composeapp.generated.resources.Res
import spacetrace.composeapp.generated.resources.settings

object SettingsTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Settings"
            val icon = painterResource(Res.drawable.settings)


            return remember {
                TabOptions(
                    index = 2u,
                    title = title,
                    icon = icon,
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(SettingsScreen())
    }
}
