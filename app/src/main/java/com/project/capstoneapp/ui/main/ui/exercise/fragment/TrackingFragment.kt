package com.project.capstoneapp.ui.main.ui.exercise.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.project.capstoneapp.R
import com.project.capstoneapp.databinding.FragmentTrackingBinding

class TrackingFragment : Fragment() {

    private var _binding: FragmentTrackingBinding? = null
    private val binding get() = _binding!!

    private lateinit var spinnerAdapter: ArrayAdapter<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTrackingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setSpinnerExercise()
        setExerciseHoursText()
    }

    private fun setSpinnerExercise() {
        spinnerAdapter = ArrayAdapter<String>(
            requireContext(),
            R.layout.dropdown_menu_popup_item,
            EXERCISE_LIST
        )

        binding.spinnerExercise.setAdapter(spinnerAdapter)
    }

    private fun setExerciseHoursText() {
        binding.tvExercise.text = binding.spinnerExercise.text
        binding.spinnerExercise.addTextChangedListener(onTextChanged = { exerciseName, _, _, _ ->
            binding.tvExercise.text = exerciseName
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        val EXERCISE_LIST = arrayOf("Swimming", "Badminton", "Billiard", "Volleyball")
    }
}