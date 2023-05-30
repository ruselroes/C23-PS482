package com.project.capstoneapp.ui.landing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.capstoneapp.databinding.ActivityLandingBinding
import com.project.capstoneapp.ui.auth.login.LoginActivity
import com.project.capstoneapp.ui.auth.register.FirstRegisterActivity

class LandingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLandingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            btnRegister.setOnClickListener {
                val iRegister = Intent(this@LandingActivity, FirstRegisterActivity::class.java)
                startActivity(iRegister)
            }

            btnLogin.setOnClickListener {
                val iLogin = Intent(this@LandingActivity, LoginActivity::class.java)
                startActivity(iLogin)
            }
        }
    }
}