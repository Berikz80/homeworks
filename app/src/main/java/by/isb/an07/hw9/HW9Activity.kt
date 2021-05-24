package by.isb.an07.hw9

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import by.isb.an07.R
import by.isb.an07.hw8.HW8ViewModel
import by.isb.an07.hw9.data.repository.advice.AdviceRepository
import kotlinx.coroutines.*

class HW9Activity : AppCompatActivity() {
    companion object {
        const val BROADCAST_ACTION_TOAST = "action.toast"
    }

    private val viewModel by lazy { ViewModelProvider(this).get(HW9ViewModel::class.java) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw9)

        val myReceiver = HW9BroadcastReceiver()

        val intentFilter = IntentFilter().apply {
            addAction(BROADCAST_ACTION_TOAST)
        }
        registerReceiver(myReceiver, intentFilter)


        viewModel.loadAdvice()

        val counterText = findViewById<TextView>(R.id.counter_text)

        findViewById<Button>(R.id.start_button).setOnClickListener {
            val serviceIntent = Intent(this, HW9ForegroundService::class.java).apply {
                putExtra("advice", viewModel.advice)
            }
            object : CountDownTimer(5000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    counterText.text = (millisUntilFinished / 1000).toString()
                }

                override fun onFinish() {
                    startService(serviceIntent)
                }
            }.start()
        }
    }
}