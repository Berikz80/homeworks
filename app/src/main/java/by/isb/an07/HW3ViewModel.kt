package by.isb.an07

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.security.AccessController.getContext
import java.util.*
import kotlin.random.Random

class HW3ViewModel : ViewModel() {

    val myRegions = arrayOf(
        MutableLiveData(Region("Гомельская область")),
        MutableLiveData(Region("Брестская область")),
        MutableLiveData(Region("Минская область")),
    )

    var isStop = MutableLiveData<Boolean>(false)

    var winner = 0

    private val random = Random(12345)

    fun startDataLoading() {

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                if (isStop.value == false) for (i in 0..2) {
                    viewModelScope.launch {
                        delay(random.nextLong(3000))
                        myRegions[i].value = myRegions[i].value?.also {
                            it.corn = it.corn.plus(random.nextLong(100).toInt())
                            it.potato = it.potato.plus(random.nextLong(100).toInt())
                            it.cabbage = it.cabbage.plus(random.nextLong(100).toInt())
                            if ((it.corn > 1000) && (it.potato > 1000) && (it.cabbage > 1000)) {
                                isStop.value = true
                                winner = i
                            }
                        }
                    }
                }
                else this.cancel()
            }
        }, 1, 3000)
    }

}

