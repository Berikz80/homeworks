package by.isb.an07.hw9

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService

class HW9BroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val manager = context?.getSystemService(NotificationManager::class.java)
        manager?.cancel(1)

        Toast.makeText(context, "Toast", Toast.LENGTH_SHORT).show()

    }
}