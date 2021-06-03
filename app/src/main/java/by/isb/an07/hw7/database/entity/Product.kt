package by.isb.an07.hw7.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
data class Product(
    val name: String,
    val price: Int,
    val image: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
) {

}