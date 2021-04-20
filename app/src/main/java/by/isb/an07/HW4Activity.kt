package by.isb.an07

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HW4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw4)

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