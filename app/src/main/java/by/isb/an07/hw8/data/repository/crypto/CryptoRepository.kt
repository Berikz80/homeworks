package by.isb.an07.hw8.data.repository.crypto

import by.isb.an07.hw8.data.mappers.crypto.CryptoResponseMapper
import by.isb.an07.hw8.data.entities.crypto.Crypto
import by.isb.an07.hw8.data.networking.crypto.CryptoApi

class CryptoRepository {

    private val api = CryptoApi.provideRetrofit()
    private val cryptoResponseMapper = CryptoResponseMapper()

    suspend fun loadCrypto(sort: String): List<Crypto> {
        val response = api.loadCrypto(sort)

        return if (response.isSuccessful) {
            response.body()?.dataIn?.map {
                cryptoResponseMapper.map(it)
            }.orEmpty()
        } else {
            throw Throwable(response.errorBody().toString())
        }
    }

}