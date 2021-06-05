package by.isb.an07.hw11.data.mappers.country

import by.isb.an07.hw11.data.dto.country.CountryResponse
import by.isb.an07.hw11.data.entities.country.Country
import by.isb.an07.hw11.data.mappers.Mapper

class CountryMapper:Mapper<CountryResponse.Country,Country> {
    override fun map(from: CountryResponse.Country): Country {
        return Country(
            name = from.name?:"",
            code = from.code?:"",
            flag = from.flag?:""
        )
    }
}