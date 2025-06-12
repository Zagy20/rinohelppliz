package com.example.agar_kapovi_parkingclick

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val currentTab = "home"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val etLocation = findViewById<EditText>(R.id.etLocation)
        val btnSearch = findViewById<Button>(R.id.btnSearch)
        val tvParkingResult = findViewById<TextView>(R.id.tvParkingResult)
        val btnReserve = findViewById<Button>(R.id.btnReserve)

        // Set home as selected by default
        bottomNav.selectedItemId = R.id.nav_home

        btnSearch.setOnClickListener {
            val location = etLocation.text.toString()
            tvParkingResult.text = "Parking mjesto pronađeno na lokaciji: $location"
        }

        btnReserve.setOnClickListener {
            tvParkingResult.text = "Parking mjesto rezervirano!"
        }

        // Setup bottom navigation
        bottomNav.setOnItemSelectedListener { item ->
            // Highlight selected item
            bottomNav.menu.findItem(item.itemId)?.isChecked = true

            when (item.itemId) {
                R.id.nav_login -> {
                    if (currentTab != "login") {
                        startActivity(Intent(this, LoginActivity::class.java))
                        overridePendingTransition(0, 0)
                    }
                    true
                }
                R.id.nav_home -> {
                    // Already on home, do nothing
                    true
                }
                R.id.nav_settings -> {
                    if (currentTab != "settings") {
                        startActivity(Intent(this, SettingsActivity::class.java))
                        overridePendingTransition(0, 0)
                    }
                    true
                }
                else -> false
            }
        }
    }

    override fun onResume() {
        super.onResume()
        // Ensure the correct tab is highlighted when returning to activity
        findViewById<BottomNavigationView>(R.id.bottom_navigation).selectedItemId = R.id.nav_home
    }
}

