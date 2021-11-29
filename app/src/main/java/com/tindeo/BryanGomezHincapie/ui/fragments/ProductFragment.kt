package com.tindeo.BryanGomezHincapie.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.tindeo.BryanGomezHincapie.R
import com.tindeo.BryanGomezHincapie.ui.listeners.OnProductListener
import com.tindeo.BryanGomezHincapie.ui.adaptares.ProductAdapter
import com.tindeo.BryanGomezHincapie.data.models.Product
import com.tindeo.BryanGomezHincapie.databinding.FragmentProductBinding
import com.tindeo.BryanGomezHincapie.ui.viewmodels.ProductViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class ProductFragment : Fragment() {

    private var _binding: FragmentProductBinding? = null
    private val binding get() = _binding!!

    private lateinit var productAdapter: ProductAdapter
    //Si queremos mostrar elementos en grid
    private lateinit var productManager: StaggeredGridLayoutManager

    private val productViewModel: ProductViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProductBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        //Esto necesita una lista para poderlo crear
        productViewModel.loadProducts()
        productAdapter = ProductAdapter(
            //Primero se queman
            //Se traen de internet
            //Despues de la db
            listOf()
        )
        productManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        //pasarle el listener al adaptador --- COmponente que escucha -- Patron delegation desde el adapter
        productAdapter.listener = object : OnProductListener {
            override fun onClick(item: Product) {
                Log.d("PRODUCT", item.name)
                productViewModel.selectProduct(item)
                findNavController().navigate(R.id.action_productFragment_to_productDetailFragment)
            }
        }

        binding.productRecycler.apply {
            adapter = productAdapter
            layoutManager = productManager
        }

        observeViewModels()
    }

    private fun observeViewModels(){
        productViewModel.products.observe(viewLifecycleOwner, { products ->
            productAdapter.newDataSet(products)
        })
    }
}