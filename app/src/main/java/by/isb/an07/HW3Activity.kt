package by.isb.an07

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class HW3Activity:AppCompatActivity() {

    lateinit var viewModel: HW3ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw3)

        viewModel = ViewModelProvider(this).get(HW3ViewModel::class.java)

        viewModel.init()



    }
}