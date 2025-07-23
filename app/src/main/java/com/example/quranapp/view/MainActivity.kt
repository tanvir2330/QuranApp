package com.example.quranapp.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.quranapp.R
import com.example.quranapp.repository.QuranRepisitory
import com.example.quranapp.retrofit.RetrofitInstance
import com.example.quranapp.viewmodel.QuranViewModel
import com.example.quranapp.viewmodel.QuranViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: QuranViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val repository = QuranRepisitory(RetrofitInstance.api)
        val factory = QuranViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[QuranViewModel::class.java]

        viewModel.verses.observe(this) { verses ->
            // Handle UI update
        }

        viewModel.translations.observe(this) { translations ->
            // Handle UI update
        }

        viewModel.getVerses()
        viewModel.getTranslations("en")
    }
}
