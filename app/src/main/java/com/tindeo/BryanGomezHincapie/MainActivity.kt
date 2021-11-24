package com.tindeo.BryanGomezHincapie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.AppBarConfiguration
import com.tindeo.BryanGomezHincapie.databinding.ActivityHomeBinding
import com.tindeo.BryanGomezHincapie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //private lateinit var  appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}