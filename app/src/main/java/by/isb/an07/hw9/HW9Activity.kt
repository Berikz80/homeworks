package by.isb.an07.hw9

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import by.isb.an07.R

class HW9Activity : AppCompatActivity() {
    companion object {
        const val BROADCAST_ACTION_TOAST = "action.toast"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw9)

        val myReceiver = HW9BroadcastReceiver()

        val intentFilter = IntentFilter().apply {
            addAction(BROADCAST_ACTION_TOAST)
        }
        registerReceiver(myReceiver, intentFilter)

        val counterText = findViewById<TextView>(R.id.counter_text)

        findViewById<Button>(R.id.start_button).setOnClickListener {

            val serviceIntent = Intent(this, HW9ForegroundService::class.java)

            object : CountDownTimer(3000,1000) {
                override fun onTick(millisUntilFinished: Long) {
                    counterText.text = (millisUntilFinished/1000).toString()
                }

                override fun onFinish() {
                    startService(serviceIntent)
                }

            }.start()

        }

    }
}