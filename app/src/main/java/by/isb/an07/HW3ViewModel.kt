package by.isb.an07

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HW3ViewModel : ViewModel() {

    val myRegions = arrayOf(MutableLiveData<Region>())

    fun init() {
        myRegions[0] = MutableLiveData(Region("Гомельская область"))
        myRegions[1] = MutableLiveData(Region("Могилевская область"))
        myRegions[2] = MutableLiveData(Region("Брестская область"))
    }



}