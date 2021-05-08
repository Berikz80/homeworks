package by.isb.an07

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.isb.an07.database.ProductDatabase
import by.isb.an07.database.entity.Product
import by.isb.an07.repository.ProductRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HW7ViewModel(application: Application) : ViewModel() {

    private val productRepository = ProductRepository(ProductDatabase.getDatabase(application))
    private val ioScope = CoroutineScope(Dispatchers.IO)

    private val _productList = MutableLiveData<List<Product>>()
    val productList : LiveData<List<Product>> = _productList

    fun insert(product: Product) {
        productRepository.insert(product)
    }

    fun loadAllPerson() {
        ioScope.launch {
            val personList = productRepository.loadAllProduct()
            _productList.postValue(personList)
        }
    }

}