package by.isb.an07.hw9.data.dto.advice


import com.google.gson.annotations.SerializedName

data class AdviceResponse(
    @SerializedName("slip")
    val slip: Slip?
) {
    data class Slip(
        @SerializedName("advice")
        val advice: String?,
        @SerializedName("id")
        val id: Int?
    )
}