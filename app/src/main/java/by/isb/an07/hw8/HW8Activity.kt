package by.isb.an07.hw8

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import by.isb.an07.R
import by.isb.an07.hw7.recycler.ProductAdapter
import by.isb.an07.hw8.recycler.CryptoAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HW8Activity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProvider(this).get(HW8ViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw8)

        val cryptoText = findViewById<TextView>(R.id.crypto_text)
        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        val recycler = findViewById<RecyclerView>(R.id.recycler_crypto)


        viewModel.crypto.observe(this) {
//            cryptoText.text = it.toString()
            val cryptoAdapter = viewModel.crypto.value?.let { CryptoAdapter(it) }
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
            else progressBar.visibility = GONE
        }

        viewModel.loadCrypto("market_cap")


    }
}