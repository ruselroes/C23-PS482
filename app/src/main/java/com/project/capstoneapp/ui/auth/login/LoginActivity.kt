package com.project.capstoneapp.ui.auth.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.capstoneapp.databinding.ActivityLoginBinding
import com.project.capstoneapp.ui.auth.register.FirstRegisterActivity
import com.project.capstoneapp.ui.main.BottomMainActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            btnLogin.setOnClickListener {
                val iMain = Intent(this@LoginActivity, BottomMainActivity::class.java)
                startActivity(iMain)
            }

            btnForgetPassword.setOnClickListener {

            }

            btnRegister.setOnClickListener {
                val iRegister = Intent(this@LoginActivity, FirstRegisterActivity::class.java)
                startActivity(iRegister)
            }
        }
    }
}