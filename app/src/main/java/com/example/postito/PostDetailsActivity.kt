package com.example.postito

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.postito.databinding.ActivityMainBinding
import com.example.postito.databinding.ActivityPostDetailsBinding

//const val POST_TITLE = "extra_movie_backdrop"
class PostDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
           binding.title2.text = intent.getStringExtra("POST_TITLE")

        }

    }




