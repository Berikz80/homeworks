package by.isb.an07.hw11.data.dto.holiday


import com.google.gson.annotations.SerializedName

data class HolidayResponse(
    @SerializedName("holidays")
    val holidays: List<Holiday?>?,
) {
    data class Holiday(
        @SerializedName("country")
        val country: String?,
        @SerializedName("date")
        val date: String?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("observed")
        val observed: String?,
        @SerializedName("public")
        val `public`: Boolean?,
        @SerializedName("uuid")
        val uuid: String?
    )

}