package by.isb.an07.hw9

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.content.Intent.getIntent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import by.isb.an07.App
import by.isb.an07.R

class HW9ForegroundService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val intentBroadcast = Intent().apply {
            action = HW9Activity.BROADCAST_ACTION_TOAST
            putExtra("advice", intent?.getStringExtra("advice"))
        }

        val actionIntent =
            PendingIntent.getBroadcast(
                this,
                777,
                intentBroadcast,
                PendingIntent.FLAG_CANCEL_CURRENT
            )

        val notification = NotificationCompat.Builder(this, App.NOTIFICATION_CHANNEL_ID)
            .setContentTitle("Advice of the day")
            .setContentText(intent?.getStringExtra("advice"))
            .setSmallIcon(R.drawable.ic_crypto)
            .setContentIntent(actionIntent)
            .setPriority(2)
            .addAction(
                R.drawable.ic_crypto,
                "open main",
                actionIntent
            ).setAutoCancel(true)
            .build()

        startForeground(1, notification)

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}