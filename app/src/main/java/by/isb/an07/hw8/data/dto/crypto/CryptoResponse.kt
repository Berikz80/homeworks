package by.isb.an07.hw8.data.dto.crypto


import com.google.gson.annotations.SerializedName

data class CryptoResponse(
    @SerializedName("status")
    val status: Status?,
    @SerializedName("data")
    val dataIn: List<Data>

) {
    data class Data(
        @SerializedName("circulating_supply")
        val circulatingSupply: Double?,
        @SerializedName("cmc_rank")
        val cmcRank: Int?,
        @SerializedName("date_added")
        val dateAdded: String?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("last_updated")
        val lastUpdated: String?,
        @SerializedName("max_supply")
        val maxSupply: Double?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("num_market_pairs")
        val numMarketPairs: Int?,
        @SerializedName("platform")
        val platform: Any?,
        @SerializedName("quote")
        val quote: Quote?,
        @SerializedName("slug")
        val slug: String?,
        @SerializedName("symbol")
        val symbol: String?,
        @SerializedName("tags")
        val tags: List<String?>?,
        @SerializedName("total_supply")
        val totalSupply: Double?
    ) {
        data class Quote(
            @SerializedName("USD")
            val usd: USD?
        ) {
            data class USD(
                @SerializedName("last_updated")
                val lastUpdated: String?,
                @SerializedName("market_cap")
                val marketCap: Double?,
                @SerializedName("percent_change_1h")
                val percentChange1h: Double?,
                @SerializedName("percent_change_24h")
                val percentChange24h: Double?,
                @SerializedName("percent_change_30d")
                val percentChange30d: Double?,
                @SerializedName("percent_change_60d")
                val percentChange60d: Double?,
                @SerializedName("percent_change_7d")
                val percentChange7d: Double?,
                @SerializedName("percent_change_90d")
                val percentChange90d: Double?,
                @SerializedName("price")
                val price: Double?,
                @SerializedName("volume_24h")
                val volume24h: Double?
            )
        }
    }

    data class Status(
        @SerializedName("credit_count")
        val creditCount: Int?,
        @SerializedName("elapsed")
        val elapsed: Int?,
        @SerializedName("error_code")
        val errorCode: Int?,
        @SerializedName("error_message")
        val errorMessage: Any?,
        @SerializedName("notice")
        val notice: Any?,
        @SerializedName("timestamp")
        val timestamp: String?,
        @SerializedName("total_count")
        val totalCount: Int?
    )
}