
import by.isb.an07.hw8.data.dto.crypto.CryptoResponse
import by.isb.an07.hw8.data.entities.crypto.Crypto


class CryptoResponseMapper : Mapper<CryptoResponse, Crypto> {

    override fun map(from: CryptoResponse): Crypto {
        return Crypto(
            circulatingSupply = from.dataIn?.circulatingSupply ?: 0,
            cmcRank = from.dataIn?.cmcRank ?: 0,
            dateAdded = from.dataIn?.dateAdded.orEmpty(),
            id = from.dataIn?.id ?: 0,
            lastUpdated = from.dataIn?.lastUpdated.orEmpty(),
            maxSupply = from.dataIn?.maxSupply ?: 0,
            name = from.dataIn?.name.orEmpty(),
            numMarketPairs = from.dataIn?.numMarketPairs ?: 0,
            slug = from.dataIn?.slug.orEmpty(),
            symbol = from.dataIn?.symbol.orEmpty(),
            totalSupply = from.dataIn?.totalSupply ?: 0,
            percentChange1h = from.dataIn?.quote?.usd?.percentChange1h ?: 0.0,
            percentChange24h = from.dataIn?.quote?.usd?.percentChange24h ?: 0.0,
            percentChange7d = from.dataIn?.quote?.usd?.percentChange7d ?: 0.0,
            percentChange30d = from.dataIn?.quote?.usd?.percentChange30d ?: 0.0,
            percentChange60d = from.dataIn?.quote?.usd?.percentChange60d ?: 0.0,
            percentChange90d = from.dataIn?.quote?.usd?.percentChange90d ?: 0.0,
            price =  from.dataIn?.quote?.usd?.price ?: 0.0,
            volume24h =  from.dataIn?.quote?.usd?.volume24h ?: 0.0
        )
    }
}