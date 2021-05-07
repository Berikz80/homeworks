package by.isb.an07.database.dao

import androidx.room.*
import by.isb.an07.database.entity.Product

@Dao
interface ProductDao {

    @Insert
    suspend fun insert(product: Product)

    @Delete
    suspend fun delete(product: Product)

    @Update
    suspend fun update(product: Product)

    @Query("SELECT * FROM product_table")
    suspend fun getAll(): List<Product>

    @Query("DELETE FROM product_table")
    suspend fun clearAll()
}