package com.example.quranapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quranapp.model.Translation
import com.example.quranapp.model.Verse
import com.example.quranapp.repository.QuranRepisitory
import kotlinx.coroutines.launch

class QuranViewModel(private val repository : QuranRepisitory):ViewModel() {
    // LiveData to hold the list of verses
    private val _verses = MutableLiveData<Verse>()
    val verses: LiveData<Verse> get() = _verses

    private val _translations = MutableLiveData<Translation>()
    val translations: LiveData<Translation> get() = _translations

    fun getVerses(){
        viewModelScope.launch {
            _verses.value = repository.getVerse()
        }
    }
    fun getTranslations(language: String) {
        viewModelScope.launch {
            _translations.value = repository.getTranslatedVerse(language)
        }
    }

}