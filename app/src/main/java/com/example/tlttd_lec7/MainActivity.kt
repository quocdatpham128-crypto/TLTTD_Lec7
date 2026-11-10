package com.example.tlttd_lec7 // Chú ý package theo dự án của bạn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.tlttd_lec7.databinding.ActivityMainBinding
import com.example.tlttd_lec7.ui.StudentListFragment // Import Fragment từ package ui

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container, StudentListFragment())
            }
        }
    }
}