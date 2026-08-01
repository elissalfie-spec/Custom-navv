package com.example.customnav

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Create a simple text view programmatically
        val textView = TextView(this).apply {
            text = "🎉 It Works!\nCustomNav is Running!"
            textSize = 24f
            setTextColor(Color.BLACK)
            gravity = Gravity.CENTER
        }
        
        // Display the text on screen
        setContentView(textView)
    }
}
