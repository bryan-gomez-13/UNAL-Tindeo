package com.tindeo.BryanGomezHincapie.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.ktx.awaitMap
import com.google.maps.android.ktx.awaitMapLoad
import com.google.android.gms.maps.model.LatLng
import com.tindeo.BryanGomezHincapie.R
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
        storeViewModel.info.observe(viewLifecycleOwner, Observer { store ->
            binding.homeTitle.text = store.name
            binding.homeAddress.text = store.address
            binding.homeDescription.text = store.description
            binding.homeMatchNumber.text = store.match.toString()
            Glide.with(binding.root).load(store.image).into(binding.homeImage)

//            //Support porque se sabe que hereda de suppport
//            val mapFragment = childFragmentManager.findFragmentById(R.id.home_map) as SupportMapFragment
//            //Cargar mapa en una corrutina - Funcion suspendida
//            lifecycleScope.launchWhenStarted {
//                //Instancia de google maps - Espera que cargue
//                val googleMap = mapFragment.awaitMap()
//                //Esperar que cargue el mapa
//                googleMap.awaitMapLoad()
//                val latlng = LatLng(store.lat!!, store.lng!!)
//                //val latlng = LatLng(store.lat!!, store.lng!!)
//                googleMap.addMarker(
//                    MarkerOptions()
//                        .position(latlng)
//                        .title(store.name)
//                )
//                val bounds = LatLngBounds.builder()
//                    .include(latlng)
//                    .build()
//                //Acomodar camara en el centro                          Paso los datos y el siguiente es el zoom
//                googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds,20))
//            }

        })
    }

}