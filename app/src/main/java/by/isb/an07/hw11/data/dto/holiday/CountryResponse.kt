package by.isb.an07.hw11.data.dto.holiday


import com.google.gson.annotations.SerializedName

data class CountryResponse(
    @SerializedName("countries")
    val countries: List<Country>,
) {
    data class Country(
        @SerializedName("code")
        val code: String?,
        @SerializedName("flag")
        val flag: String?,
        @SerializedName("name")
        val name: String?,
    )
}