package com.example.quranapp.retrofit

object RetrofitInstance {
    private val retrofit by lazy {
        retrofit2.Retrofit.Builder()
            .baseUrl("https://api.alquran.cloud/") // Replace with your base URL
            .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
            .build()
    }
    val api: QuranApiService by lazy {
        retrofit.create(QuranApiService::class.java)
    }
}