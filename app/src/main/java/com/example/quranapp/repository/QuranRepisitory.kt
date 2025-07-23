package com.example.quranapp.repository

import com.example.quranapp.model.Translation
import com.example.quranapp.model.Verse
import com.example.quranapp.retrofit.QuranApiService

class QuranRepisitory(private val api: QuranApiService) {

    suspend fun getVerses(): List<Verse> {
        return api.getVerses()
    }

    suspend fun getTranslations(language: String): List<Translation> {
        return api.getTranslations(language)
    }
}
