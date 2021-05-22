package by.isb.an07.hw9.data.mappers.advice

import by.isb.an07.hw8.data.dto.crypto.CryptoResponse
import by.isb.an07.hw8.data.entities.crypto.Crypto
import by.isb.an07.hw8.data.mappers.Mapper
import by.isb.an07.hw9.data.dto.advice.Advice
import by.isb.an07.hw9.data.dto.advice.AdviceResponse

class AdviceResponseMapper : Mapper<AdviceResponse, Advice> {

    override fun map(from: AdviceResponse): Advice {
        return Advice(
            advice = from.slip?.advice?:""
        )
    }
}