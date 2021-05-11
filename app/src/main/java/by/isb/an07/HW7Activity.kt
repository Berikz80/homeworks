package by.isb.an07

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import by.isb.an07.recycler.ProductAdapter


class HW7Activity : AppCompatActivity() {

    lateinit var viewModel: HW7ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw7)

        viewModel =
            ViewModelProvider.AndroidViewModelFactory(application).create(HW7ViewModel::class.java)
        val recycler = findViewById<RecyclerView>(R.id.recycler)

//        viewModel.insert(Product("Milk",100,""))
//        viewModel.insert(Product("Bread",200,""))
//        viewModel.insert(Product("Beer",300,""))

        viewModel.loadAllProduct()

        viewModel.productList.observe(this) {
            val productsAdapter = viewModel.productList.value?.let { ProductAdapter(it) }
            recycler.adapter = productsAdapter
        }

        findViewById<EditText>(R.id.quick_find).addTextChangedListener(
            object : TextWatcher {
                override fun afterTextChanged(s: Editable) {
                    val productsAdapter = viewModel.productList.value?.filter {
                        it.name.contains(s, true)
                    }?.let { ProductAdapter(it) }
                    recycler.adapter = productsAdapter
                }

                override fun beforeTextChanged(
                    s: CharSequence, start: Int, count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(
                    s: CharSequence, start: Int, before: Int,
                    count: Int
                ) {
                }
            })


    }
}