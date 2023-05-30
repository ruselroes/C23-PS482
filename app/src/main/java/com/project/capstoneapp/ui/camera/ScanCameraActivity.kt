package com.project.capstoneapp.ui.camera

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.project.capstoneapp.R
import com.project.capstoneapp.databinding.ActivityScanCameraBinding

class ScanCameraActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScanCameraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScanCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.layoutAppBar)

        setStatusBarColor()
        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            layoutAppBar.setNavigationOnClickListener {
                finish()
            }

            btnFlash.setOnClickListener {

            }

            btnShutter.setOnClickListener {
                val iCalculate = Intent(this@ScanCameraActivity, CalculateScanActivity::class.java)
                startActivity(iCalculate)
                finish()
            }

            btnImage.setOnClickListener {

            }
        }
    }

    private fun setStatusBarColor() {
        val window: Window = this.window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, R.color.primaryColorBlue)
    }
}