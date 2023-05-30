package com.project.capstoneapp.ui.camera

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.project.capstoneapp.R
import com.project.capstoneapp.databinding.ActivityCalculateScanBinding

class CalculateScanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculateScanBinding

    private lateinit var spinnerRestaurantAdapter: ArrayAdapter<String>
    private lateinit var spinnerFoodAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculateScanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.layoutAppBar)

        setStatusBarColor()
        setSpinnerItem()
        setListeners()
    }

    private fun setSpinnerItem() {
        binding.apply {
            spinnerRestaurantAdapter = ArrayAdapter<String>(
                this@CalculateScanActivity,
                R.layout.dropdown_menu_popup_item,
                RESTAURANT_LIST
            )

            spinnerFoodAdapter = ArrayAdapter<String>(
                this@CalculateScanActivity,
                R.layout.dropdown_menu_popup_item,
                FOOD_LIST
            )

            spinnerRestaurant.setAdapter(spinnerRestaurantAdapter)
            spinnerFood.setAdapter(spinnerFoodAdapter)
        }
    }

    private fun setListeners() {
        binding.apply {
            layoutAppBar.setNavigationOnClickListener {
                finish()
            }

            btnFinish.setOnClickListener {
                finish()
            }

        }
    }

    private fun setStatusBarColor() {
        val window: Window = this.window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, R.color.primaryColorBlue)
    }

    companion object {
        val RESTAURANT_LIST = arrayOf("Burger King", "Mc Donald", "KFC", "Popeyes")
        val FOOD_LIST = arrayOf("BigMac Small", "BigMac Regular", "BigMac Jumbo")
    }
}