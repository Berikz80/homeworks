package by.isb.an07

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class HW4Activity : AppCompatActivity() {

    lateinit var viewModel: HW4ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw4)

        viewModel = ViewModelProvider(this).get(HW4ViewModel::class.java)

        val buttonAdd = findViewById<Button>(R.id.button_add_snowdrop)
        val buttonShow = findViewById<Button>(R.id.button_show_snowdrop)

        val addSnowdropFragment = AddSnowdropFragment()

        buttonAdd.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, addSnowdropFragment)
                .commit()
        }
    }
}