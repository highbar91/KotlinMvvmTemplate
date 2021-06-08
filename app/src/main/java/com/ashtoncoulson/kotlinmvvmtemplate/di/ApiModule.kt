package com.ashtoncoulson.kotlinmvvmtemplate.di

import com.ashtoncoulson.kotlinmvvmtemplate.BuildConfig
import com.ashtoncoulson.kotlinmvvmtemplate.api.ApiClient
import com.ashtoncoulson.kotlinmvvmtemplate.api.ApiContract
import com.ashtoncoulson.kotlinmvvmtemplate.model.adapter.NullToEmptyJsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val apiModule = module {
    single { ApiClient(get()) }
    single { createApiContract() }
}

private fun createApiContract(): ApiContract {
    val headerInterceptor = Interceptor { chain ->
        val requestBuilder = chain.request().newBuilder()
        requestBuilder
            .addHeader("Example_Header", "example/header.val")
        chain.proceed(requestBuilder.build())
    }

    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    }

    val httpClient = OkHttpClient.Builder()
        .addInterceptor(headerInterceptor)
        .addInterceptor(loggingInterceptor)
        .build()

    val moshi = Moshi.Builder()
        .add(NullToEmptyJsonAdapter())
        // Always add custom adapters above KotlinJsonAdapterFactory
        .add(KotlinJsonAdapterFactory())
        .build()

    val moshiConverterFactory = MoshiConverterFactory
        .create(moshi)
        .withNullSerialization()

    val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(httpClient)
        .addConverterFactory(moshiConverterFactory)
        .build()

    return retrofit.create(ApiContract::class.java)
}
