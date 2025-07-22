package com.example.quranapp.retrofit

import com.example.quranapp.model.Translation
import com.example.quranapp.model.Verse
import retrofit2.http.GET
import retrofit2.http.Query

interface QuranApiService {
    @GET("quran/verses")
    suspend fun getVerses(): List<Verse>

    @GET("quran/translations")
    suspend fun getTranslations(@Query("language") language: String): List<Translation>
}