package karel.hudera.spacetrace.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import karel.hudera.spacetrace.presentation.ui.screens.launches.LaunchesScreen
import org.jetbrains.compose.resources.painterResource
import spacetrace.composeapp.generated.resources.Res
import spacetrace.composeapp.generated.resources.rocket

object RocketLaunchTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Rockets"
            val icon = painterResource(Res.drawable.rocket)


            return remember {
                TabOptions(
                    index = 1u,
                    title = title,
                    icon = icon,
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(LaunchesScreen())
    }
}