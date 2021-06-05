package by.isb.an07.hw11.data.mappers.holiday

import by.isb.an07.hw11.data.dto.holiday.HolidayResponse
import by.isb.an07.hw11.data.entities.holiday.Holiday
import by.isb.an07.hw11.data.mappers.Mapper

class HolidayMapper:Mapper<HolidayResponse.Holiday,Holiday> {
    override fun map(from: HolidayResponse.Holiday): Holiday {
        return Holiday(
            date = from.date?:"",
            name = from.name?:""
        )
    }
}