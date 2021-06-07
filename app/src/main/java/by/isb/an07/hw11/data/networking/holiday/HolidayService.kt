package by.isb.an07.hw11.data.networking.holiday

import by.isb.an07.hw11.data.dto.holiday.CountryResponse
import by.isb.an07.hw11.data.dto.holiday.HolidayResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface HolidayService {

    @GET("/v1/countries")
    fun loadCountries(): Observable<CountryResponse>

    @GET("v1/holidays?country={country_code}&year=2020&month={month}&day={day}&upcoming=true")
    fun loadHolidays(
        @Query("country_code") countryCode:String,
        @Query("day") day:Int,
        @Query("month") month:Int
    ): Observable<HolidayResponse>

}