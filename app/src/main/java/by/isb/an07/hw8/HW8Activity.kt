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
import com.google.android.material.slider.RangeSlider
import kotlin.math.roundToInt

class HW8Activity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProvider(this).get(HW8ViewModel::class.java) }

    val times = arrayOf("1h", "24h", "7d", "30d", "60d", "90d")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw8)

        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        val recycler = findViewById<RecyclerView>(R.id.recycler_crypto)
        val quickFind = findViewById<EditText>(R.id.quick_find_crypto)

        viewModel.crypto.observe(this) {
            val cryptoAdapter = viewModel.crypto.value?.let { CryptoAdapter(it, 0) }
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
            }
        }

        fun updateAdapter(search: String, timeR: Int) {
            val cryptoAdapter = viewModel.crypto.value?.filter {
                it.name.contains(search, true) || it.symbol.contains(search, true)
            }?.let { CryptoAdapter(it, timeR) }
            recycler.adapter = cryptoAdapter
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
                    viewModel.setFilter(s.toString())
                    updateAdapter(viewModel.filter.value?:"", viewModel.timeRange.value ?: 0)
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
                    if (quickFind.visibility == GONE) quickFind.visibility = VISIBLE
                    else quickFind.visibility = GONE
                    true
                }
                R.id.refresh -> {
                    viewModel.loadCrypto()
                    true
                }
                R.id.sort_by_marketcap -> {
                    viewModel.setSort("market_cap")
                    true
                }
                R.id.sort_by_name -> {
                    viewModel.setSort("name")
                    true
                }
                R.id.sort_by_price -> {
                    viewModel.setSort("price")
                    true
                }
                else -> false
            }
        }

        val timeSlider =
            findViewById<RangeSlider>(R.id.crypto_timerange_slider)

        timeSlider.setLabelFormatter { value: Float ->
            return@setLabelFormatter "${times[value.roundToInt()]}"
        }

        timeSlider.addOnChangeListener(object : RangeSlider.OnChangeListener {

            override fun onValueChange(slider: RangeSlider, value: Float, fromUser: Boolean) {

                viewModel.setTimeRange(value.roundToInt())
                updateAdapter(viewModel.filter.value?:"", viewModel.timeRange.value ?: 0)
                topAppBar.title = "Change in ${times[value.roundToInt()]}"


            }
        })

        viewModel.loadCrypto()

    }
}