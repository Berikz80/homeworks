package by.isb.an07

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.isb.an07.database.entity.Product

class HW7ViewModel : ViewModel() {

    private val _productList = MutableLiveData<List<Product>>()
    val productList : LiveData<List<Product>> = _productList

}