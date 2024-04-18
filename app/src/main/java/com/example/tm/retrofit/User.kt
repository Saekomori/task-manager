package com.example.tm.retrofit

data class User(
    val email: String,
    val lastName: String? = null,
    val firstName: String? = null,
    val password: String,
    val username: String,
    val token: String
)
