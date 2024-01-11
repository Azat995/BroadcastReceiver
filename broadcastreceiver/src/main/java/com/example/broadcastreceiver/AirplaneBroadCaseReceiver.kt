package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AirplaneBroadCaseReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneModeEnabled = intent?.getBooleanExtra("state", false) ?: return
        Log.d("Airplane", "onReceive: Airplane mode enabled: $isAirplaneModeEnabled")
    }
}