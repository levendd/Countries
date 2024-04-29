package com.levojuk.countries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.levojuk.countries.databinding.ItemCountryBinding
import com.levojuk.countries.model.Country

class CountryAdapter(val countryList: ArrayList<Country> ):RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
    class CountryViewHolder( val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {


        return CountryViewHolder(ItemCountryBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
       return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countryList[position]
        holder.binding.countryName.text =countryList[position].countryName
        holder.binding.countryRegion.text =countryList[position].countryRegion




    }
    fun updateCountryList(newCountryList :List<Country>){
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }
}