package edu.temple.classnotes

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var countdowntextView : TextView
    val broadcastReceiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            countdowntextView.text = intent?.getStringExtra("timerValue")!!
        }

    }
    lateinit var  intentFilter : IntentFilter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        intentFilter = IntentFilter()
        countdowntextView = findViewById(R.id.textView)

        findViewById<Button>(R.id.button).setOnClickListener{
            startService(Intent(this, CountdownService::class.java).putExtra())
        }
    }

    override fun onResume(){
        super.onResume()
        registerReciever(broadcastReceiver, intentFilter)
    }

    override fun
}