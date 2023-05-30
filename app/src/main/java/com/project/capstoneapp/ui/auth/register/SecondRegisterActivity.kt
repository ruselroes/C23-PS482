package com.project.capstoneapp.ui.auth.register

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import com.project.capstoneapp.R
import com.project.capstoneapp.databinding.ActivitySecondRegisterBinding
import com.project.capstoneapp.ui.main.BottomMainActivity
import java.text.SimpleDateFormat
import java.util.*

class SecondRegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondRegisterBinding

    private lateinit var spinnerAdapter: ArrayAdapter<String>
    private lateinit var calendar: Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setForm()
        setListeners()
    }

    private fun setForm() {
        spinnerAdapter = ArrayAdapter<String>(
            this,
            R.layout.dropdown_menu_popup_item,
            GENDER_LIST
        )

        binding.spinnerGender.setAdapter(spinnerAdapter)

        calendar = Calendar.getInstance()

        val date = OnDateSetListener { _: DatePicker?, year: Int, month: Int, day: Int ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, day)
            updateDateLabel()
        }

        binding.edDate.setOnClickListener { v: View? ->
            DatePickerDialog(
                this,
                date,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    private fun setListeners() {
        binding.btnRegister.setOnClickListener {
            val iMain = Intent(this@SecondRegisterActivity, BottomMainActivity::class.java)
            startActivity(iMain)
        }
    }

    private fun updateDateLabel() {
        val myFormat = "MM/dd/yy"
        val dateFormat = SimpleDateFormat(myFormat, Locale.US)
        binding.edDate.setText(dateFormat.format(calendar.getTime()))
    }

    companion object {
        val GENDER_LIST = arrayOf("Men", "Women")
    }
}