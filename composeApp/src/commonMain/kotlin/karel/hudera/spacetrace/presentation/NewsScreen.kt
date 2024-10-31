package karel.hudera.spacetrace.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import karel.hudera.spacetrace.platform.getHttpClientEngineFactory
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
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

    @Composable
    override fun Content() {
        val scope = rememberCoroutineScope()
        var text by remember { mutableStateOf("Loading") }

        LaunchedEffect(true) {
            scope.launch {
                text = try {
                    Greeting().greeting()
                } catch (e: Exception) {
                    e.message ?: "error"
                }
            }

            delay(1000)

        }
        GreetingView(text)
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

class Greeting {
    private val nativeEngine = getHttpClientEngineFactory().getEngine()
    private val client = HttpClient(nativeEngine)
    suspend fun greeting(): String {
        return try {
            val response = client.get("https://api.spacexdata.com/v5/launches")
            response.bodyAsText()
        } catch (e: Exception) {
            "Error: ${e.message}"
        }
    }
}