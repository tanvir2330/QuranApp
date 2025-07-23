package com.example.quranapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.quranapp.repository.QuranRepisitory

class QuranViewModelFactory(private val repository: QuranRepisitory) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuranViewModel(repository) as T
    }
}
