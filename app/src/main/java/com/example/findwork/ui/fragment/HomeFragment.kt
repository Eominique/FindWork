package com.example.findwork.ui.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import com.example.findwork.R
import com.example.findwork.data.model.Job
import com.example.findwork.databinding.HomeFragmentBinding
import com.example.findwork.ui.adapter.JobsAdapter
import com.example.findwork.ui.adapter.MarkerAdapter
import com.example.findwork.utils.SessionManager
import com.example.findwork.utils.setupTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!
    private var currentJob: Int = 40
    private var totalAvailableJobs: Int = 1

    lateinit var jobsAdapter: JobsAdapter
    lateinit var markerAdapter: MarkerAdapter
    private var titleCurrentJob: String = ""
    val jobs: ArrayList<Job> by lazy {
        ArrayList()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkTheme()

        binding.notif.setOnClickListener {
            if (SessionManager.getMyTheme(requireActivity())) {
                //dark to light
                SessionManager.setThemeMode(requireActivity(), false)
                val unwrappedDrawable = AppCompatResources.getDrawable(
                    requireContext(),
                    R.drawable.ic_round_dark_mode_24
                )
                val wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable!!)
                DrawableCompat.setTint(wrappedDrawable, Color.BLACK)
                binding.notif.setImageDrawable(wrappedDrawable)
            } else {
                //light to dark
                SessionManager.setThemeMode(requireActivity(), true)
                val unwrappedDrawable =
                    AppCompatResources.getDrawable(
                        requireContext(),
                        R.drawable.ic_baseline_light_mode_24
                    )
                val wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable!!)
                DrawableCompat.setTint(wrappedDrawable, Color.WHITE)
                binding.notif.setImageDrawable(wrappedDrawable)

                setupTheme(true)
            }
        }

    }

    private fun checkTheme() {
        if (SessionManager.getMyTheme(requireActivity())) {
            val unwrappedDrawable = AppCompatResources.getDrawable(
                requireContext(),
                R.drawable.ic_baseline_light_mode_24
            )
            val wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable!!)
            DrawableCompat.setTint(wrappedDrawable, Color.WHITE)
            binding.notif.setImageDrawable(wrappedDrawable)
        } else {
            val unwrappedDrawable =
                AppCompatResources.getDrawable(
                    requireContext(),
                    R.drawable.ic_round_dark_mode_24
                )
            val wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable!!)
            DrawableCompat.setTint(wrappedDrawable, Color.BLACK)
            binding.notif.setImageDrawable(wrappedDrawable)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}