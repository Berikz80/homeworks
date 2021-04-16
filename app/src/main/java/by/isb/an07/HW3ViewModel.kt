package by.isb.an07

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*
import kotlin.random.Random

class HW3ViewModel : ViewModel() {

    val myRegions = arrayOf(
        MutableLiveData(Region("Гомельская область")),
        MutableLiveData(Region("Брестская область")),
        MutableLiveData(Region("Минская область")),
    )
    var isStop = false

    private val random = Random(12345)

    fun startDataLoading() {

//        for (j in 0..100) {
//            while (!isStop) {
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {

                for (i in 0..2) {
                    viewModelScope.launch {
                        delay(random.nextLong(3000))
                        myRegions[i].value = myRegions[i].value?.also {
                            it.corn = it.corn.plus(random.nextLong(100).toInt())
                            it.potato = it.potato.plus(random.nextLong(100).toInt())
                            it.cabbage = it.cabbage.plus(random.nextLong(100).toInt())
                            isStop = it.corn > 1000
                        }
                    }
                }
            }
        }, 1, 3000)
    }

}

