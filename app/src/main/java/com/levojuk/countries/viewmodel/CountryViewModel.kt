package com.levojuk.countries.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.levojuk.countries.model.Country

class CountryViewModel (application: Application) : BaseViewModel(application) {
    val countryLiveData = MutableLiveData<Country>()
    fun getDataFromRoom(){
        val country = Country("Turkey","Ankara","Asia","TRY","Turkish","www.ss.com")
        countryLiveData.value=country
    }
}