package com.ashtoncoulson.kotlinmvvmtemplate.model.adapter

import androidx.annotation.Keep
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonQualifier
import com.squareup.moshi.ToJson

@Retention(AnnotationRetention.RUNTIME)
@Keep
annotation class Nullable

@Retention(AnnotationRetention.RUNTIME)
@JsonQualifier
annotation class NullToEmpty

class NullToEmptyJsonAdapter {

    @ToJson
    fun emptyStringToJsonNull(@NullToEmpty text: String?): String? {
        return when {
            text.isNullOrBlank() -> null
            else -> text
        }
    }

    @FromJson
    @NullToEmpty
    fun emptyStringFromJsonNull(@Nullable text: String?): String {
        return text ?: ""
    }
}