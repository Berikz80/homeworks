package by.isb.an07

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.hw1_button).setOnClickListener {
            startActivity(Intent(this,HW1Activity::class.java))
        }

        findViewById<Button>(R.id.hw2_button).setOnClickListener {
            startActivity(Intent(this,HW2Activity::class.java))
        }

        findViewById<Button>(R.id.hw3_button).setOnClickListener {
            startActivity(Intent(this,HW3Activity::class.java))
        }

        findViewById<Button>(R.id.hw4_button).setOnClickListener {
            startActivity(Intent(this,HW4Activity::class.java))
        }

        findViewById<Button>(R.id.hw5_button).setOnClickListener {
            startActivity(Intent(this,HW5Activity::class.java))
        }
    }
}