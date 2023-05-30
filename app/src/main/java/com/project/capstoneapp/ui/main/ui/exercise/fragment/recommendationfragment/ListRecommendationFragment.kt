package com.project.capstoneapp.ui.main.ui.exercise.fragment.recommendationfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.project.capstoneapp.R
import com.project.capstoneapp.adapter.RecommendationListAdapter
import com.project.capstoneapp.databinding.FragmentListRecommendationBinding
import com.project.capstoneapp.models.RecommendationActivity

class ListRecommendationFragment : Fragment() {

    private var _binding: FragmentListRecommendationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListRecommendationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecommendationContent()
        setOnBackPressed()
    }

    private fun setRecommendationContent() {
        binding.rvRecommendation.apply {
            val staggeredGridLayoutManager =
                StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            val recommendationListAdapter = RecommendationListAdapter(fillRecomendationList())

            layoutManager = staggeredGridLayoutManager
            adapter = recommendationListAdapter
        }
    }

    private fun fillRecomendationList(): ArrayList<RecommendationActivity> {
        val recommendationList = ArrayList<RecommendationActivity>()

        recommendationList.add(
            RecommendationActivity(
                name = "Running",
                time = 41,
                image = AppCompatResources.getDrawable(requireContext(), R.drawable.running)
            )
        )

        recommendationList.add(
            RecommendationActivity(
                name = "Swimming",
                time = 33,
                image = AppCompatResources.getDrawable(requireContext(), R.drawable.swimming)
            )
        )

        recommendationList.add(
            RecommendationActivity(
                name = "Cycling",
                time = 30,
                image = AppCompatResources.getDrawable(requireContext(), R.drawable.cycling)
            )
        )

        recommendationList.add(
            RecommendationActivity(
                name = "Workout",
                time = 35,
                image = AppCompatResources.getDrawable(requireContext(), R.drawable.pushup)
            )
        )

        recommendationList.add(
            RecommendationActivity(
                name = "Badminton",
                time = 25,
                image = AppCompatResources.getDrawable(requireContext(), R.drawable.badminton)
            )
        )

        recommendationList.add(
            RecommendationActivity(
                name = "Volleyball",
                time = 30,
                image = AppCompatResources.getDrawable(requireContext(), R.drawable.volleyball)
            )
        )

        return recommendationList
    }

    private fun setOnBackPressed() {
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(requireActivity(), object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (isEnabled) {
                        isEnabled = false
                        parentFragmentManager.beginTransaction().apply {
                            replace(
                                R.id.container_recommendation,
                                FormRecommendationFragment(),
                                FormRecommendationFragment::class.java.simpleName
                            )
                            commit()
                        }
                    }
                }
            }
            )
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}