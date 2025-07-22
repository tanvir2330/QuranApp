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

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: QuranViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val repository = QuranRepisitory(RetrofitInstance.api)
        viewModel = ViewModelProvider(this).get(QuranViewModel::class.java)

        viewModel.verses.observe(this, observer{

        })
        viewModel.getVerses()
        viewModel.getTranslations("en")
    }
}