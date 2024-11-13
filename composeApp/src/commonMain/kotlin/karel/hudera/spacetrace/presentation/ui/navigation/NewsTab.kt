package karel.hudera.spacetrace.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import karel.hudera.spacetrace.presentation.ui.features.news.NewsScreen
import org.jetbrains.compose.resources.painterResource
import spacetrace.composeapp.generated.resources.Res
import spacetrace.composeapp.generated.resources.globe

object NewsTab : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = "News"
            val icon = painterResource(Res.drawable.globe)


            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon,
                )
            }
        }

    @Composable
    override fun Content() {
       Navigator(NewsScreen())
    }
}