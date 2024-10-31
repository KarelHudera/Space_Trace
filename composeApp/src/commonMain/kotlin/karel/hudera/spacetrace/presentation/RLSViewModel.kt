package karel.hudera.spacetrace.presentation// CounterViewModel.kt
import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class RLSViewModel : ScreenModel {

    private val _counter = MutableStateFlow(0)
    val counter: StateFlow<Int> get() = _counter.asStateFlow()

    private var job: Job? = null

    init {
        startAutoIncrement()
    }

    private fun startAutoIncrement() {
        job = CoroutineScope(Dispatchers.Main).launch {
            while (isActive) {
                delay(1000)
                _counter.value += 1
            }
        }
    }

    private fun stopAutoIncrement() {
        job?.cancel()
    }
}