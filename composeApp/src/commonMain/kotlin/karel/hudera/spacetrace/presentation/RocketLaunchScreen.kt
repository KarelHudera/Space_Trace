package karel.hudera.spacetrace.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import org.jetbrains.compose.resources.painterResource
import spacetrace.composeapp.generated.resources.Res
import spacetrace.composeapp.generated.resources.rocket

object RocketLaunchScreen : Tab {
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
    }
}