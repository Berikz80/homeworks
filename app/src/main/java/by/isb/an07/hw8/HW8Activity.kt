package by.isb.an07.hw8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import by.isb.an07.R
import by.isb.an07.hw8.recycler.CryptoAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HW8Activity : AppCompatActivity() {

       private val viewModel by lazy { ViewModelProvider(this).get(HW8ViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw8)

        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        val recycler = findViewById<RecyclerView>(R.id.recycler_crypto)
        val quickFind = findViewById<EditText>(R.id.quick_find_crypto)

        viewModel.queryParams.value?.put("sort", "market_cap")
        viewModel.queryParams.value?.put("sortDir", "desc")

        viewModel.crypto.observe(this) {
            val cryptoAdapter = viewModel.crypto.value?.let { CryptoAdapter(it,0) }
            recycler.adapter = cryptoAdapter
        }

        viewModel.errorBus.observe(this) {
            MaterialAlertDialogBuilder(this)
                .setTitle("Error loading API")
                .setMessage(it)
                .show()
        }

        viewModel.loading.observe(this) {
            if (it) progressBar.visibility = VISIBLE
            else {
                progressBar.visibility = GONE
                Toast.makeText(this, "Cryptos loaded order by ${viewModel.sort} ${viewModel.sortDir} ", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.queryParams.observe(this) {
      //      viewModel.loadCrypto()
        }

        quickFind.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }

                override fun afterTextChanged(s: Editable) {
                    val cryptoAdapter = viewModel.crypto.value?.filter {
                        it.name.contains(s, true) || it.symbol.contains(s, true)
                    }?.let { CryptoAdapter(it,0) }
                    recycler.adapter = cryptoAdapter
                }

            }
        )

        val topAppBar =
            findViewById<com.google.android.material.appbar.MaterialToolbar>(R.id.crypto_topAppBar)

        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.sort_direction -> {
                    viewModel.switchSortDirection()
                 true
                }
                R.id.search -> {
                    if (quickFind.visibility==GONE) quickFind.visibility= VISIBLE
                    else quickFind.visibility= GONE
                    true
                }
                R.id.refresh -> {
                    viewModel.loadCrypto()
                    true
                }
                else -> false
            }
        }

        viewModel.loadCrypto()


    }
}