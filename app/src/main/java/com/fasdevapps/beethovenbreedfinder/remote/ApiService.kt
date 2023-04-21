package com.fasdevapps.beethovenbreedfinder.remote

import com.fasdevapps.beethovenbreedfinder.BASE_URL
import retrofit2.Retrofit

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)