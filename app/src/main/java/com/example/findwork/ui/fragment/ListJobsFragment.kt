package com.example.findwork.ui.fragment

import androidx.fragment.app.Fragment
import com.example.findwork.databinding.ListJobsFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListJobsFragment : Fragment() {

    private var _binding: ListJobsFragmentBinding? = null
    private val binding get() = _binding!!

    private var titleCurrentJob: String = ""


}