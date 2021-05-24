package by.isb.an07.hw9

import android.widget.Toast
import androidx.lifecycle.ViewModel
import by.isb.an07.hw9.data.repository.advice.AdviceRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HW9ViewModel : ViewModel() {

    var advice : String = ""
    var errorBus : String = ""

    val adviceRepository = AdviceRepository()
    val ioScope = CoroutineScope(Dispatchers.IO)

    fun loadAdvice() {
        ioScope.launch {
            try {
                advice = adviceRepository.loadAdvice()
            } catch (e: Exception) {
               errorBus =  e.message?:""
            }
        }
    }

}