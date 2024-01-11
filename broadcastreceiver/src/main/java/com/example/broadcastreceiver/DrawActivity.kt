package com.example.broadcastreceiver

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DrawActivity : AppCompatActivity() {

    private var drawingView: DrawingView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        drawingView = DrawingView(this)
        setContentView(drawingView)
    }
}