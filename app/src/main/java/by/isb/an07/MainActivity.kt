package by.isb.an07

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonHw1 = findViewById<Button>(R.id.hw1_button)
        val buttonHw2 = findViewById<Button>(R.id.hw2_button)
        val buttonHw3 = findViewById<Button>(R.id.hw3_button)

        buttonHw1.setOnClickListener {
            startActivity(Intent(this,HW1Activity::class.java))
        }

        buttonHw2.setOnClickListener {
            startActivity(Intent(this,HW2Activity::class.java))
        }

        buttonHw3.setOnClickListener {
            startActivity(Intent(this,HW3Activity::class.java))
        }
    }
}