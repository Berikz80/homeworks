package by.isb.an07

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import by.isb.an07.hw1.HW1Activity
import by.isb.an07.hw2.HW2Activity
import by.isb.an07.hw3.HW3Activity
import by.isb.an07.hw4.HW4Activity
import by.isb.an07.hw5.HW5Activity
import by.isb.an07.hw6.HW6Activity
import by.isb.an07.hw7.HW7Activity
import by.isb.an07.hw8.HW8Activity
import by.isb.an07.hw9.HW9Activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.hw1_button).setOnClickListener {
            startActivity(Intent(this, HW1Activity::class.java))
        }

        findViewById<Button>(R.id.hw2_button).setOnClickListener {
            startActivity(Intent(this, HW2Activity::class.java))
        }

        findViewById<Button>(R.id.hw3_button).setOnClickListener {
            startActivity(Intent(this, HW3Activity::class.java))
        }

        findViewById<Button>(R.id.hw4_button).setOnClickListener {
            startActivity(Intent(this, HW4Activity::class.java))
        }

        findViewById<Button>(R.id.hw5_button).setOnClickListener {
            startActivity(Intent(this, HW5Activity::class.java))
        }

        findViewById<Button>(R.id.hw6_button).setOnClickListener {
            startActivity(Intent(this, HW6Activity::class.java))
        }

        findViewById<Button>(R.id.hw7_button).setOnClickListener {
            startActivity(Intent(this, HW7Activity::class.java))
        }

        findViewById<Button>(R.id.hw8_button).setOnClickListener {
            startActivity(Intent(this, HW8Activity::class.java))
        }

        findViewById<Button>(R.id.hw9_button).setOnClickListener {
            startActivity(Intent(this, HW9Activity::class.java))
        }
    }
}