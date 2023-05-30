package com.project.capstoneapp.ui.main.ui.exercise.fragment.recommendationfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.project.capstoneapp.R
import com.project.capstoneapp.databinding.FragmentFormRecommendationBinding

class FormRecommendationFragment : Fragment() {

    private var _binding: FragmentFormRecommendationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormRecommendationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListeners()
    }

    private fun setListeners() {
        binding.btnOk.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(
                    R.id.container_recommendation,
                    ListRecommendationFragment(),
                    ListRecommendationFragment::class.java.simpleName
                )
                commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}