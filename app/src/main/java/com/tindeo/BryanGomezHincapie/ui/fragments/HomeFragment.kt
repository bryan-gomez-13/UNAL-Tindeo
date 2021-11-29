package com.tindeo.BryanGomezHincapie.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.tindeo.BryanGomezHincapie.databinding.FragmentHomeBinding
import com.tindeo.BryanGomezHincapie.ui.viewmodels.StoreViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    //Inyectar el view model
    //View model atado al ciclo de vida de la actividad "sharedViewModel()"
    private val storeViewModel: StoreViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        storeViewModel.loadInfo()
        observeViewModels()
    }

    private fun observeViewModels(){
        storeViewModel.info.observe(viewLifecycleOwner, { store ->
            binding.homeTitle.text = store.name
            binding.homeAddress.text = store.address
            binding.homeDescription.text = store.description
            binding.homeMatchNumber.text = store.match.toString()
            Glide.with(binding.root).load(store.image).into(binding.homeImage)
        })
    }

}