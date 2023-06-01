package com.example.findwork.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.findwork.data.model.Job
import com.example.findwork.databinding.HomeFragmentBinding
import com.example.findwork.ui.adapter.JobsAdapter
import com.example.findwork.ui.adapter.MarkerAdapter
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