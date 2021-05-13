package by.isb.an07.hw7

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import by.isb.an07.database.ProductDatabase
import by.isb.an07.database.entity.Product
import by.isb.an07.hw7.repository.ProductRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HW7ViewModel(application: Application) : AndroidViewModel(application) {

    private val productRepository = ProductRepository(ProductDatabase.getDatabase(application))
    private val ioScope = CoroutineScope(Dispatchers.IO)

    private val _productList = MutableLiveData<List<Product>>()
    val productList : LiveData<List<Product>> = _productList

    fun insert(product: Product) {
        productRepository.insert(product)
        loadAllProduct()
    }

    fun loadAllProduct() {
        ioScope.launch {
            val productList = productRepository.loadAllProduct()
            _productList.postValue(productList)
        }
    }

    fun clearAllProduct() {
        ioScope.launch {
            productRepository.clearAllProduct()
        }
    }

}