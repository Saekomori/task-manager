package com.example.tm.retrofit

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    companion object {
        const val AUTHENTICATE_ENDPOINT = "auth/authenticate"
        const val REGISTER_ENDPOINT = "auth/register"
    }
    @POST(AUTHENTICATE_ENDPOINT)
    suspend fun auth(@Body authRequest: AuthRequest): Response<User>

    @POST(REGISTER_ENDPOINT)
    suspend fun reg(@Body regRequest: RegRequest): Response<User>
}