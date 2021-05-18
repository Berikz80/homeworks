package by.isb.an07.hw7.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import by.isb.an07.hw7.database.dao.ProductDao
import by.isb.an07.hw7.database.entity.Product

@Database(entities = [Product::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object {
        var INSTANCE: ProductDatabase? = null

        fun getDatabase(context: Context): ProductDatabase {

            return if (INSTANCE == null) {
                INSTANCE =
                    Room.databaseBuilder(context, ProductDatabase::class.java, "database").build()
                INSTANCE as ProductDatabase
            } else INSTANCE as ProductDatabase
        }
    }
}