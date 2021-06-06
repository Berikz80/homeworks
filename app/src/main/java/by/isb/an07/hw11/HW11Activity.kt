package by.isb.an07.hw11

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.ProgressBar
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

class HW11Activity : AppCompatActivity() {

    lateinit var disposables: CompositeDisposable

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
            .subcribe({},{})
    }
}