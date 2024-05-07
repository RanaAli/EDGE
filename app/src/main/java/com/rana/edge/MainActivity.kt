package com.rana.edge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rana.edge.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using view binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Set the content view to the inflated layout
        setContentView(binding.root)

    }
}