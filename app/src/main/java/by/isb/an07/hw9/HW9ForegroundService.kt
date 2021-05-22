package by.isb.an07.hw9

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import by.isb.an07.App
import by.isb.an07.R

class HW9ForegroundService : Service() {

    override fun onCreate() {
        super.onCreate()

        val contentIntent = PendingIntent.getActivity(
            this, 999,
            Intent(this, HW9Activity::class.java),
            PendingIntent.FLAG_CANCEL_CURRENT
        )

        val intent = Intent().apply {
            action = HW9Activity.BROADCAST_ACTION_TOAST
        }

        val actionIntent =
            PendingIntent.getBroadcast(
                this,
                777,
                intent,
                PendingIntent.FLAG_CANCEL_CURRENT
            )

        val notification = NotificationCompat.Builder(this, App.NOTIFICATION_CHANNEL_ID)
            .setContentTitle("Homeworks Message")
            .setContentText("Notification succeed")
            .setSmallIcon(R.drawable.ic_crypto)
            .setContentIntent(contentIntent)
            .setPriority(2)
            .addAction(
                R.drawable.ic_crypto,
                "open main",
                actionIntent
            ).setAutoCancel(true)
            .build()

        startForeground(1,notification)

    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}