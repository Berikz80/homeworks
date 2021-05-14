package by.isb.an07.hw8.data.mappers.crypto
import by.isb.an07.hw8.data.dto.crypto.CryptoResponse
import by.isb.an07.hw8.data.entities.crypto.Crypto
import by.isb.an07.hw8.data.mappers.Mapper

class CryptoResponseMapper : Mapper<CryptoResponse.Data, Crypto> {

    override fun map(from: CryptoResponse.Data): Crypto {
        return Crypto(
            circulatingSupply = from.circulatingSupply ?: 0,
            cmcRank = from.cmcRank ?: 0,
            dateAdded = from.dateAdded.orEmpty(),
            id = from.id ?: 0,
            lastUpdated = from.lastUpdated.orEmpty(),
            maxSupply = from.maxSupply ?: 0,
            name = from.name.orEmpty(),
            numMarketPairs = from.numMarketPairs ?: 0,
            slug = from.slug.orEmpty(),
            symbol = from.symbol.orEmpty(),
            totalSupply = from.totalSupply ?: 0,
            percentChange1h = from.quote?.usd?.percentChange1h ?: 0.0,
            percentChange24h = from.quote?.usd?.percentChange24h ?: 0.0,
            percentChange7d = from.quote?.usd?.percentChange7d ?: 0.0,
            percentChange30d = from.quote?.usd?.percentChange30d ?: 0.0,
            percentChange60d = from.quote?.usd?.percentChange60d ?: 0.0,
            percentChange90d = from.quote?.usd?.percentChange90d ?: 0.0,
            price =  from.quote?.usd?.price ?: 0.0,
            volume24h =  from.quote?.usd?.volume24h ?: 0.0
        )
    }
}