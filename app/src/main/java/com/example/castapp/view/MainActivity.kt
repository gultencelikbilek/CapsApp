package com.example.castapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.castapp.adapter.CapsAdapter
import com.example.castapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val mainViewModel : MainViewModel by viewModels()
    private var capsAdapter = CapsAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.getAllCaps()
        getData()
        setUpRv()
    }

    private fun setUpRv() {
            capsAdapter = CapsAdapter(this)
            binding.recyclerviewCaps.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = capsAdapter
                setHasFixedSize(true)
        }
    }

    private fun getData() {
        mainViewModel.caps.observe(this){
            println("memes: $it")
            capsAdapter.differ.submitList(it)
        }

        mainViewModel.isLoading.observe(this){
            binding.progressBar.isVisible = it
        }
    }
}