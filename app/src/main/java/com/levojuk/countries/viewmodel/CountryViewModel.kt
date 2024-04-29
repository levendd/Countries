package com.levojuk.countries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.levojuk.countries.model.Country

class CountryViewModel : ViewModel() {
    val countryLiveData = MutableLiveData<Country>()
    fun getDataFromRoom(){
        val country = Country("Turkey","Ankara","Asia","TRY","Turkish","www.ss.com")
        countryLiveData.value=country
    }
}