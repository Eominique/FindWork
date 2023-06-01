package com.example.findwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.findwork.databinding.ActivityMainBinding
import com.example.findwork.utils.SessionManager
import com.example.findwork.utils.setupTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupTheme(SessionManager.getMyTheme(this))
    }

}