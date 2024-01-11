package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.broadcastreceiver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var airplaneBroadCastReceiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBroadCastReceiver()
        setClickListeners()
    }

    private fun initBroadCastReceiver() {
//        airplaneBroadCastReceiver = object : BroadcastReceiver() {
//            override fun onReceive(context: Context?, intent: Intent?) {
//                val isAirplaneModeEnabled = intent?.getBooleanExtra("state", false) ?: return
//                showToast("Airplane mode enabled: $isAirplaneModeEnabled")
//            }
//        }
        airplaneBroadCastReceiver = AirplaneBroadCaseReceiver()
    }

    private fun setClickListeners() = with(binding) {
        startButton.setOnClickListener {
            val intentFilter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            registerReceiver(airplaneBroadCastReceiver, intentFilter)
        }
        stopButton.setOnClickListener {
            unregisterReceiver(airplaneBroadCastReceiver)
        }
    }
}