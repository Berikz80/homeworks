package by.isb.an07.hw8.data.repository.crypto

import CryptoResponseMapper
import by.isb.an07.hw8.data.entities.crypto.Crypto
import by.isb.an07.hw8.data.networking.crypto.CryptoApi

class CryptoRepository {

    private val api = CryptoApi.provideRetrofit()
    private val cryptoResponseMapper = CryptoResponseMapper()

    suspend fun loadCrypto(periodicity: String): List<Crypto> {
        val response = api.loadCrypto("name")

        return if (response.isSuccessful) {
            response.body()?.map {
                cryptoResponseMapper.map(it)
            }.orEmpty()
        } else {
            throw Throwable(response.errorBody().toString())
        }
    }

}