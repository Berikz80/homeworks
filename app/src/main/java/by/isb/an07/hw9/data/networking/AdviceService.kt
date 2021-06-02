package by.isb.an07.hw9.data.networking

import by.isb.an07.hw8.data.dto.crypto.CryptoResponse
import by.isb.an07.hw9.data.dto.advice.AdviceResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AdviceService {

    @GET("/advice")
    suspend fun loadAdvice(
    ): Response<AdviceResponse>
}