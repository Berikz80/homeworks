package by.isb.an07.repository

import by.isb.an07.database.ProductDatabase
import by.isb.an07.database.entity.Product
import kotlinx.coroutines.*

class ProductRepository(
    private val database: ProductDatabase
) {

    private val dao = database.productDao()
    private val ioScope = CoroutineScope(Dispatchers.IO)

    fun insert(product: Product) {
        ioScope.launch {
            dao.insert(product)
        }
    }

    suspend fun loadAllPerson(): List<Product> {
        return ioScope.async { dao.getAll() }.await()
    }
}