package com.levojuk.countries.service


import com.levojuk.countries.model.Country
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface CountryAPI {


    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    fun getCountries():Observable<List<Country>>


}