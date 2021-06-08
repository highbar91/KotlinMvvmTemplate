package com.ashtoncoulson.kotlinmvvmtemplate.model

sealed class PhoneNumber {
    data class Home(val number: String, val fax: String) : PhoneNumber()
    data class Mobile(val number: String) : PhoneNumber()
    data class Work(val number: String) : PhoneNumber()
    data class Other(val number: String) : PhoneNumber()
}