package com.levojuk.countries.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.levojuk.countries.R
import com.levojuk.countries.databinding.FragmentCountryBinding
import com.levojuk.countries.viewmodel.CountryViewModel

class CountryFragment : Fragment() {
    private lateinit var viewModel :CountryViewModel
    private lateinit var binding : FragmentCountryBinding

private var countryUuid = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCountryBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this)[CountryViewModel::class.java]
        viewModel.getDataFromRoom()
        arguments?.let {
            countryUuid =CountryFragmentArgs.fromBundle(it).countryUuid
        }
        observeLiveData()
    }
  private  fun observeLiveData(){
        viewModel.countryLiveData.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.countryName2.text = it.countryName
                binding.countryCapital2.text = it.countryCapital
                binding.countryLanguage2.text = it.countryLanguage
                binding.countryRegion2.text = it.countryRegion
                binding.countryCurrency2.text = it.countryCurrency
            }
        })
    }
}