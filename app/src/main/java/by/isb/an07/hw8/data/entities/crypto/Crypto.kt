package by.isb.an07.hw8.data.entities.crypto

data class Crypto(
    val circulatingSupply: Double,
    val cmcRank: Int,
    val dateAdded: String,
    val id: Int,
    val lastUpdated: String,
    val maxSupply: Double,
    val name: String,
    val numMarketPairs: Int,
//    val platform: Any,
    val slug: String,
    val symbol: String,
//    val tags: List<String>,
    val totalSupply: Double,
//    val marketCap: Double,
    val percentChange: Array<Double>,
    val price: Double,
    val volume24h: Double
)