package by.isb.an07

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HW5ActivityWelcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw5_welcome)

        val textName = findViewById<TextView>(R.id.welcome_user)

        textName.text = getString(R.string.welcome_string)+intent.getStringExtra("NAME")
    }
}