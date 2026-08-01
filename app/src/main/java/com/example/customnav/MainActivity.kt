package com.example.customnav

import android.app.Activity
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    private lateinit var container: LinearLayout
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Root Layout - Dark Mode Background
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.parseColor("#121212"))
        }

        // Main Content Area (Switches content dynamically)
        container = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1.0f
            )
        }
        root.addView(container)

        // Custom Bottom Navigation Bar
        val navBar = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            setBackgroundColor(Color.parseColor("#1E1E1E"))
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            setPadding(16, 24, 16, 24)
        }

        // Navigation Tab Buttons
        val homeBtn = createNavButton("🏠 Home") { showHomeScreen() }
        val featuresBtn = createNavButton("⚡ Features") { showFeaturesScreen() }
        val settingsBtn = createNavButton("⚙️ Settings") { showSettingsScreen() }

        navBar.addView(homeBtn)
        navBar.addView(featuresBtn)
        navBar.addView(settingsBtn)

        root.addView(navBar)
        setContentView(root)

        // Load Default Screen
        showHomeScreen()
    }

    private fun createNavButton(title: String, onClick: () -> Unit): Button {
        return Button(this).apply {
            text = title
            setTextColor(Color.WHITE)
            setBackgroundColor(Color.TRANSPARENT)
            layoutParams = LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1.0f
            )
            setOnClickListener { onClick() }
        }
    }

    // --- SCREEN 1: HOME ---
    private fun showHomeScreen() {
        container.removeAllViews()

        val title = TextView(this).apply {
            text = "Welcome Home! 🏠"
            textSize = 28f
            setTypeface(null, Typeface.BOLD)
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "Tap the navigation tabs below to switch screens."
            textSize = 15f
            setTextColor(Color.GRAY)
            gravity = Gravity.CENTER
            setPadding(0, 16, 0, 32)
        }

        val actionBtn = Button(this)
        actionBtn.text = "Click Count: $counter"
        actionBtn.setBackgroundColor(Color.parseColor("#BB86FC"))
        actionBtn.setTextColor(Color.BLACK)
        actionBtn.setPadding(32, 16, 32, 16)
        actionBtn.setOnClickListener {
            counter++
            actionBtn.text = "Click Count: $counter"
        }

        container.addView(title)
        container.addView(subtitle)
        container.addView(actionBtn)
    }

    // --- SCREEN 2: FEATURES ---
    private fun showFeaturesScreen() {
        container.removeAllViews()

        val title = TextView(this).apply {
            text = "⚡ App Features"
            textSize = 28f
            setTypeface(null, Typeface.BOLD)
            setTextColor(Color.parseColor("#03DAC6"))
            gravity = Gravity.CENTER
        }

        val desc = TextView(this).apply {
            text = "✓ Dark Mode UI\n✓ Custom Bottom Navigation\n✓ Dynamic View Switching\n✓ Native Android Performance"
            textSize = 18f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
            setPadding(0, 24, 0, 0)
            setLineSpacing(12f, 1f)
        }

        container.addView(title)
        container.addView(desc)
    }

    // --- SCREEN 3: SETTINGS ---
    private fun showSettingsScreen() {
        container.removeAllViews()

        val title = TextView(this).apply {
            text = "⚙️ Settings"
            textSize = 28f
            setTypeface(null, Typeface.BOLD)
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
        }

        val resetBtn = Button(this)
        resetBtn.text = "Reset Counter"
        resetBtn.setBackgroundColor(Color.parseColor("#CF6679"))
        resetBtn.setTextColor(Color.WHITE)
        resetBtn.setOnClickListener {
            counter = 0
            resetBtn.text = "Counter Reset!"
        }

        container.addView(title)
        container.addView(resetBtn)
    }
}
