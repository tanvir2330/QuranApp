package com.example.quranapp.retrofit

object RetrofitInstance {
    private val retrofit by lazy {
        retrofit2.Retrofit.Builder()
            .baseUrl("1. http://api.alquran.cloud/v1/quran/{{edition}}") // Replace with your base URL
            .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
            .build()
    }
    val api: QuranApiService by lazy {
        retrofit.create(QuranApiService::class.java)
    }
}