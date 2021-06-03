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
        val product = Product("123", 150, "test")
        runBlocking {
            productDao.insert(product)

            Truth.assertThat(productDao.getAll()).contains(product)
        }

    }
}