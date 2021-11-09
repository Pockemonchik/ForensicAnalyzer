package com.example.forensicanalyzer

import android.animation.Animator
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.WindowManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.forensicanalyzer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentView(this, R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        navView.setupWithNavController(navController)
        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_report -> {
                    var addReportContainer: ConstraintLayout = findViewById(R.id.add_report_container)
                    addReportContainer.visibility = VISIBLE
                }
                R.id.navigation_overview -> {
                    navController.navigate(R.id.navigation_overview)
                }
                R.id.navigation_cloud -> {
                    navController.navigate(R.id.navigation_cloud)
                }

            }
            true
        }

        binding.closeImageView.setOnClickListener(addReportClickListener)
    }
    private val addReportClickListener: View.OnClickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.closeImageView -> {
                GONE.also { binding.addReportContainer.visibility = it }
            }
        }

    }
}