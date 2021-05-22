package by.isb.an07.hw9

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import by.isb.an07.R

class HW9Activity(millisInFuture: Long) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw9)

        val counterText = findViewById<TextView>(R.id.counter_text)

        findViewById<Button>(R.id.start_button).setOnClickListener {

            object : CountDownTimer(10000,1000) {
                override fun onTick(millisUntilFinished: Long) {
                    counterText.text = (millisUntilFinished/1000).toString()
                }

                override fun onFinish() {

                }

            }

        }

    }
}