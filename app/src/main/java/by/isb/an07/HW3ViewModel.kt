package by.isb.an07

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class HW3ViewModel : ViewModel() {

    val myRegions = arrayOf(MutableLiveData<Region>())

    val random = Random(12345)

    fun startDataLoading() {

        fun loadInt(): Int {
            var r = 0
            viewModelScope.launch {
                delay(random.nextLong(5000))
                r = random.nextLong(100).toInt()
            }
            return r
        }
        myRegions[0] = MutableLiveData(Region("Гомельская область"))
        myRegions[1] = MutableLiveData(Region("Могилевская область"))
        myRegions[2] = MutableLiveData(Region("Брестская область"))

        while (true) {

            for (i in 0..2) {
                myRegions[i].value?.corn?.plus(loadInt())
                myRegions[i].value?.potato?.plus(loadInt())
                myRegions[i].value?.cabbage?.plus(loadInt())
            }

        }




    }


}