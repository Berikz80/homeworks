package by.isb.an07

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import by.isb.an07.hw7.database.ProductDatabase
import by.isb.an07.hw7.database.dao.ProductDao
import by.isb.an07.hw7.database.entity.Product
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class HW7DatabaseTests {

    lateinit var productDao : ProductDao

    @Before
    fun init (){
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

        val db = Room.inMemoryDatabaseBuilder(appContext, ProductDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        productDao = db.productDao()
    }

    @Test
    fun insertProduct_returnTrue() {
        val product = Product("Name", 150, "Image",1)
        runBlocking {
            productDao.insert(product)
            Truth.assertThat(productDao.getAll()).contains(product)
        }
    }

    @Test
    fun deleteProduct_returnTrue() {
        val product = Product("Name", 150, "Image")
        runBlocking {
            productDao.insert(product)
            productDao.delete(product)
            Truth.assertThat(productDao.getAll()).doesNotContain(product)
        }
    }

    @Test
    fun updateProduct_returnTrue() {
        val product = Product("Name", 150, "Image",1)
        val product2 = Product("Name changed", 150, "Image",1)
        runBlocking {
            productDao.insert(product)
            productDao.update(product2)
            Truth.assertThat(productDao.getAll()).contains(product2)
        }
    }

    @Test
    fun updateDiffProduct_returnTrue() {
        val product = Product("Name", 150, "Image",1)
        val product2 = Product("Name changed", 150, "Image",2)
        runBlocking {
            productDao.insert(product)
            productDao.update(product2)
            Truth.assertThat(productDao.getAll()).doesNotContain(product2)
        }
    }

    @Test
    fun getAllProduct_returnTrue() {
        val product = Product("Name", 150, "Image",1)
        val product2 = Product("Name2", 150, "Image",2)
        val product3 = Product("Name3", 150, "Image",3)
        runBlocking {
            productDao.insert(product)
            productDao.insert(product2)
            productDao.insert(product3)
            Truth.assertThat(productDao.getAll()).containsExactlyElementsIn(listOf(product,product2,product3))
        }
    }

    @Test
    fun clearAllProduct_returnTrue() {
        val product = Product("Name", 150, "Image",1)
        val product2 = Product("Name2", 150, "Image",2)
        val product3 = Product("Name3", 150, "Image",3)
        runBlocking {
            productDao.insert(product)
            productDao.insert(product2)
            productDao.insert(product3)
            productDao.clearAll()
            Truth.assertThat(productDao.getAll()).isEmpty()
        }
    }

}