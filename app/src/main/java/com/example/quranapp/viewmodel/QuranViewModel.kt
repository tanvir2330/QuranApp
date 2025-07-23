package com.example.quranapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quranapp.model.Translation
import com.example.quranapp.model.Verse
import com.example.quranapp.repository.QuranRepisitory
import kotlinx.coroutines.launch

class QuranViewModel(private val repository: QuranRepisitory) : ViewModel() {

    private val _verses = MutableLiveData<List<Verse>>()
    val verses: LiveData<List<Verse>> get() = _verses

    private val _translations = MutableLiveData<List<Translation>>()
    val translations: LiveData<List<Translation>> get() = _translations

    fun getVerses() {
        viewModelScope.launch {
            _verses.value = repository.getVerses()
        }
    }

    fun getTranslations(language: String) {
        viewModelScope.launch {
            _translations.value = repository.getTranslations(language)
        }
    }
}
