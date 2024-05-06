package com.levojuk.countries.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.levojuk.countries.model.Country
import com.levojuk.countries.service.CountryAPIServices
import com.levojuk.countries.service.CountryDatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.launch


class FeedViewModel(application: Application) : BaseViewModel(application) {
    private val countryApiService = CountryAPIServices()
    private val disposable = CompositeDisposable()
    val countries = MutableLiveData<List<Country>>()
    val countryError = MutableLiveData<Boolean>()
    val countryLoading = MutableLiveData<Boolean>()

    fun refreshData(){
    getDataFromAPI()
    }
    private fun getDataFromAPI(){
        countryLoading.value =true

        disposable.add(
            countryApiService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<List<Country>>() {
                    override fun onNext(t: List<Country>) {
                        storeInSQLite(t)
                    }

                    override fun onError(e: Throwable) {
                        countryLoading.value = false
                        countryError.value = true
                        e.printStackTrace()
                    }

                    override fun onComplete() {
                        // Burası gerekirse doldurulabilir
                    }
                })

        )

    }
    private fun showCounrtries(countryList: List<Country>){
        countries.value = countryList
        countryError.value = false
        countryLoading.value = false
    }
    private fun storeInSQLite(list: List<Country>){
        launch {
            val dao = CountryDatabase(getApplication()).countryDao()
            dao.deleteCountry()
            val listLong =dao.insertAll(*list.toTypedArray())
            var i = 0
            while (i <list.size){
                list[i].uuid = listLong[i].toInt()
                i++
            }
            showCounrtries(list)
        }
    }
}