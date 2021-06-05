package by.isb.an07.hw11.data.networking.holiday

import by.isb.an07.hw11.data.dto.holiday.CountryResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface HolidayService {

    @GET("/v1/countries")
    fun loadCountry(): Observable<CountryResponse>

    @GET("v1/holidays?country={country_code}&year=2020")
    fun loadHolidays(
        @Path("country_code")
        countryCode:String
    ): Observable<HolidayResponse>

}