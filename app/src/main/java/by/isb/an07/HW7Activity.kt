package by.isb.an07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import by.isb.an07.database.entity.Product
import by.isb.an07.recycler.ProductAdapter

class HW7Activity : AppCompatActivity() {

    lateinit var viewModel : HW7ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw7)

        viewModel = ViewModelProvider.AndroidViewModelFactory(application).create(HW7ViewModel::class.java)

        viewModel.insert(Product("Milk",100,""))
        viewModel.insert(Product("Bread",200,""))
        viewModel.insert(Product("Beer",300,""))

        // load to products

        val productsAdapter = viewModel.productList.value?.let { ProductAdapter(it) }

        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.adapter = productsAdapter

    }
}