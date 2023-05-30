package com.project.capstoneapp.ui.main.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.capstoneapp.adapter.ActivitiesHomeAdapter
import com.project.capstoneapp.adapter.FoodHomeAdapter
import com.project.capstoneapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setDonutChart()
        setFoodAndActivitiesRecyclerView()
    }

    private fun setDonutChart() {
        binding.apply {
            val caloryOne = 500.0
            val caloryTwo = 2000.0
            caloryOne / caloryTwo

            tvCaloryPercentage.text =
                StringBuilder("${caloryOne.toInt()}/${caloryTwo.toInt()} Kcal")
            donutChart.setProgress(((caloryOne / caloryTwo) * 100).toInt())
        }
    }

    private fun setFoodAndActivitiesRecyclerView() {
        binding.apply {
            val foodHomeAdapter = FoodHomeAdapter(ArrayList())
            val activitiesHomeAdapter = ActivitiesHomeAdapter()

            val dividerItemDecoration = DividerItemDecoration(
                requireContext(),
                LinearLayoutManager(requireContext()).orientation
            )

            rvFoodHome.apply {
                addItemDecoration(dividerItemDecoration)
                layoutManager = LinearLayoutManager(requireContext())
                adapter = foodHomeAdapter
            }

            rvActivityHome.apply {
                addItemDecoration(dividerItemDecoration)
                layoutManager = LinearLayoutManager(requireContext())
                adapter = activitiesHomeAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}