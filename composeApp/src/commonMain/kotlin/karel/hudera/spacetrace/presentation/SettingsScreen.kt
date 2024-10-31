package karel.hudera.spacetrace.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import org.jetbrains.compose.resources.painterResource
import spacetrace.composeapp.generated.resources.Res
import spacetrace.composeapp.generated.resources.settings

object SettingsScreen : Tab {
    override val key: ScreenKey = uniqueScreenKey
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

    }

}
