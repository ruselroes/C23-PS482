package com.project.capstoneapp.ui.main.ui.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.capstoneapp.R
import com.project.capstoneapp.databinding.FragmentHomeBinding
import com.project.capstoneapp.databinding.FragmentProfileBinding
import com.project.capstoneapp.ui.landing.LandingActivity

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            btnEditProfile.setOnClickListener {
                val iEdit = Intent(requireContext(), EditProfileActivity::class.java)
                startActivity(iEdit)
            }

            btnLogout.setOnClickListener {
                val iLanding = Intent(requireContext(), LandingActivity::class.java)
                requireActivity().finishAffinity()
                startActivity(iLanding)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}