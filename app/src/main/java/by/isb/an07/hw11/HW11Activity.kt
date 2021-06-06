package by.isb.an07.hw11

import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.isb.an07.R
import by.isb.an07.hw11.data.entities.holiday.Country
import by.isb.an07.hw11.data.mappers.holiday.CountryMapper
import by.isb.an07.hw11.data.networking.holiday.HolidayApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class HW11Activity : AppCompatActivity() {

    lateinit var disposables: CompositeDisposable

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_hw11)

        val adapter = CountryAdapter()

        val recycler = findViewById<RecyclerView>(R.id.recycler_country)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        disposables = CompositeDisposable()

        HolidayApi.provideRetrofit().loadCountries()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap {
                val list = it.countries?.map {
                    CountryMapper().map(it)
                }

                findViewById<ProgressBar>(R.id.country_progress_bar).visibility = View.GONE

                adapter.init(list as ArrayList<Country>)

                Observable.fromIterable(list).subscribeOn(Schedulers.io())
            }
            .subscribe({ country->
                HolidayApi.provideRetrofit().loadHolidays(country.code)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ holidayResponse ->

                        var updateCountry =  adapter.getCurrentList().find {
                            it.code==country.code
                        }

                        val nextHoliday = holidayResponse.holidays.find{
                            val date = LocalDate.parse(it.date, DateTimeFormatter.ISO_DATE)
                            val current = LocalDate.now().minusYears(1)
                            (date>=current)
                        }

                        updateCountry?.nextHoliday = nextHoliday?.name?:""
                        updateCountry?.nextHolidayDate = nextHoliday?.date?:""

                        adapter.updateItem(updateCountry)

                    },{

                    })
            },{

            })
    }
}