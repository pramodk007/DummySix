package com.example.dummysix.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dummysix.R
import com.example.dummysix.core.utils.viewBinding
import com.example.dummysix.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.util.logging.Logger

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}