package karel.hudera.spacetrace.presentation

import RLSViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.annotation.ExperimentalVoyagerApi
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import karel.hudera.spacetrace.presentation.model.ResourceUiState
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import org.koin.core.annotation.KoinExperimentalAPI
import spacetrace.composeapp.generated.resources.Res
import spacetrace.composeapp.generated.resources.globe

object NewsScreen : Tab {

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

    @OptIn(ExperimentalVoyagerApi::class, KoinExperimentalAPI::class)
    @Composable
    override fun Content() {
        val viewModel = koinInject<RLSViewModel>()

        val newsState by viewModel.newsState.collectAsState()  // ResourceUiState<String>

        Column {
            when (newsState) {
                is ResourceUiState.Loading -> Text(text = "Loadinghh...")
                is ResourceUiState.Success -> {
                    val newsUrl = (newsState as ResourceUiState.Success).data
                    GreetingView(newsUrl)  // Display the fetched data
                }

                is ResourceUiState.Error -> {
                    val errorMessage = (newsState as ResourceUiState.Error).message
                    Text(text = "Error: $errorMessage")  // Display the error message
                }

                is ResourceUiState.Idle -> Text(text = "Idle state")
                is ResourceUiState.Empty -> Text(text = "No content available")
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}