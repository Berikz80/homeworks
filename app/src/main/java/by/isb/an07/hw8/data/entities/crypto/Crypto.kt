package by.isb.an07.hw8.data.entities.crypto

data class Crypto(
    val circulatingSupply: Int,
    val cmcRank: Int,
    val dateAdded: String,
    val id: Int,
    val lastUpdated: String,
    val maxSupply: Int,
    val name: String,
    val numMarketPairs: Int,
//    val platform: Any,
    val slug: String,
    val symbol: String,
//    val tags: List<String>,
    val totalSupply: Int,
//    val marketCap: Double,
    val percentChange1h: Double,
    val percentChange24h: Double,
    val percentChange30d: Double,
    val percentChange60d: Double,
    val percentChange7d: Double,
    val percentChange90d: Double,
    val price: Double,
    val volume24h: Double
)