import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import io.github.aakira.napier.Napier
import karel.hudera.spacetrace.domain.interactors.GetPictureUseCase
import karel.hudera.spacetrace.presentation.model.ResourceUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class RLSViewModel(
    private val getNewsUseCase: GetPictureUseCase,
) : ScreenModel, KoinComponent {

    // StateFlow to represent the UI state
    private val _newsState = MutableStateFlow<ResourceUiState<String>>(ResourceUiState.Idle)
    val newsState: StateFlow<ResourceUiState<String>> = _newsState.asStateFlow()

    // Auto-increment counter (optional)
    private val _counter = MutableStateFlow(0)
    val counter: StateFlow<Int> = _counter.asStateFlow()

    init {
        startAutoIncrement()
        fetchNews()
    }

    private fun startAutoIncrement() {
        screenModelScope.launch {
            while (true) {
                delay(1000)
                _counter.value += 1
            }
        }
    }

    private fun fetchNews() {
        _newsState.value = ResourceUiState.Loading
        screenModelScope.launch {
            getNewsUseCase(Unit)
                .onSuccess { response ->
                    _newsState.value = ResourceUiState.Success(response.url)
                    Napier.i { "Received URL: ${response.url}" }
                }
                .onFailure { exception ->
                    _newsState.value = ResourceUiState.Error(exception.message ?: "Unknown error")
                    Napier.i { "Error fetching news: ${exception.message}" }
                }
        }
    }

    override fun onDispose() {
        super.onDispose()
        // Additional cleanup if needed
    }
}