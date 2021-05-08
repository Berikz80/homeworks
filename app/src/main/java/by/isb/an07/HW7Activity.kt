package by.isb.an07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import by.isb.an07.recycler.ProductAdapter

class HW7Activity : AppCompatActivity() {

    lateinit var viewModel : HW7ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw7)

        viewModel = ViewModelProvider(this).get(HW7ViewModel::class.java)

        val recycler = findViewById<RecyclerView>(R.id.recycler)

        // load to products

        val productsAdapter = ProductAdapter(viewModel.productList)

        recycler.adapter = productsAdapter

    }
}