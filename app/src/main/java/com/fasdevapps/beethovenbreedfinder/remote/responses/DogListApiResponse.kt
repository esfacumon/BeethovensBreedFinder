package com.fasdevapps.beethovenbreedfinder.remote.responses

import com.squareup.moshi.Json

class DogListApiResponse(
    val message: String,
    @field:Json (name = "isSuccess") val isSuccess: Boolean,
    val data: DogListResponse
)