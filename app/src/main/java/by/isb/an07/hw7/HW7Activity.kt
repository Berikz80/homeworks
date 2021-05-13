package by.isb.an07.hw7

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import by.isb.an07.R
import by.isb.an07.hw7.recycler.ProductAdapter


class HW7Activity : AppCompatActivity() {

    lateinit var viewModel: HW7ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw7)

        viewModel =
            ViewModelProvider.AndroidViewModelFactory(application).create(HW7ViewModel::class.java)
        val recycler = findViewById<RecyclerView>(R.id.recycler)

//        viewModel.clearAllProduct()

//        viewModel.insert(
//            Product(
//                "Milk",
//                100,
//                "https://vestnikapk.ru/upload/iblock/c18/c18a934499271860c62492bbacc61d0b.jpg"
//            )
//        )
//        viewModel.insert(
//            Product(
//                "Bread",
//                200,
//                "https://www.womanhit.ru/media/CACHE/images/articleimage2/2019/10/1_1OvoaJ9/461e9af0419634ff8d9ff98ca6f35e0a.png"
//            )
//        )
//        viewModel.insert(Product("Tomato", 300, "https://zooclub.ru/attach/26000/26403.jpg"))
//        viewModel.insert(
//            Product(
//                "Beer",
//                400,
//                "https://calorizator.ru/sites/default/files/imagecache/product_512/product/beer-3.jpg"
//            )
//        )

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

        findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.floating_action_button).setOnClickListener {

            AddProductDialog().show(
                supportFragmentManager,
                AddProductDialog.TAG
            )
        }
    }
}