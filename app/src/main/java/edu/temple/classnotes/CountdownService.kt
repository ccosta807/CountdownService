package edu.temple.classnotes

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class CountdownService : IntentService("CountdownService") {

    override fun onHandleIntent(intent: Intent?) {

        var start = intent?.getIntExtra("timerStart", 10)!!

        for (i in start downTo 1){

            LocalBroadcastManager.getInstance(this)
                .sendBroadcast(Intent("MY_TIMER_ACTION").putExtra("timerValue", i.toString()))

            Log.d("Countdown", i.toString())
            Thread.sleep(1000)
        }
    }

}