package by.isb.an07

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_hw3.*

class HW3Activity : AppCompatActivity() {

    lateinit var viewModel: HW3ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw3)

        viewModel = ViewModelProvider(this).get(HW3ViewModel::class.java)

        viewModel.myRegions[0].observe(this) {
            text1_1.text = it.corn.toString()
            text1_2.text = it.potato.toString()
            text1_3.text = it.cabbage.toString()
        }

        viewModel.myRegions[1].observe(this) {
            text2_1.text = it.corn.toString()
            text2_2.text = it.potato.toString()
            text2_3.text = it.cabbage.toString()
        }

        viewModel.myRegions[2].observe(this) {
            text3_1.text = it.corn.toString()
            text3_2.text = it.potato.toString()
            text3_3.text = it.cabbage.toString()
        }

    }
}