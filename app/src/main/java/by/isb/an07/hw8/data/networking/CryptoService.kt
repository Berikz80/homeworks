package by.isb.an07.hw8.data.networking

import by.isb.an07.hw8.data.dto.crypto.CryptoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoService {

    @GET("/v1/cryptocurrency/listings/latest")
    suspend fun loadCryptos(
        @Query("sort")
        sort: String
    ): Response<List<CryptoResponse>>
}