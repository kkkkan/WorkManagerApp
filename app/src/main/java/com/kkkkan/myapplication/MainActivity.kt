package com.kkkkan.myapplication

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {

    val channelId = "default"

    lateinit var button1: Button
    lateinit var button2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (notificationManager.getNotificationChannel(channelId) == null) {
                val mChannel = NotificationChannel(channelId, "notification", NotificationManager.IMPORTANCE_HIGH)
                mChannel.apply {
                    description = "show Notification"
                }
                notificationManager.createNotificationChannel(mChannel)
            }
        }

        button1 = findViewById(R.id.button1)
        button1.setOnClickListener({
            val builder = NotificationCompat.Builder(this@MainActivity, channelId)
            builder.setContentTitle("notification")
            builder.setSmallIcon(R.drawable.ic_launcher_background)
            val n = builder.notification
            NotificationManagerCompat.from(this).notify(0, n)
        })


        button2 = findViewById(R.id.button2)
        button2.setOnClickListener({
            val builder = OneTimeWorkRequest.Builder(MyWorker::class.java)

            val work = builder.build()

            WorkManager.getInstance().enqueue(work)
        })
    }


}
