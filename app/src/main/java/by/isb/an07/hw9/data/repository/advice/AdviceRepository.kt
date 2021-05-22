package by.isb.an07.hw9.data.repository.advice

import by.isb.an07.hw8.data.mappers.crypto.CryptoResponseMapper
import by.isb.an07.hw8.data.entities.crypto.Crypto
import by.isb.an07.hw8.data.networking.crypto.CryptoApi
import by.isb.an07.hw9.data.dto.advice.Advice
import by.isb.an07.hw9.data.mappers.advice.AdviceResponseMapper
import by.isb.an07.hw9.data.networking.advice.AdviceApi

class AdviceRepository {

    private val api = AdviceApi.provideRetrofit()
    private val adviceResponseMapper = AdviceResponseMapper()

    suspend fun loadAdvice(): String {
        val response = api.loadAdvice()

        return if (response.isSuccessful) {
            response.body()?.slip?.advice?:""
        } else {
            throw Throwable(response.errorBody().toString())
        }
    }

}