package com.tindeo.BryanGomezHincapie.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.google.android.material.transition.MaterialContainerTransform
import com.tindeo.BryanGomezHincapie.databinding.FragmentProductDetailBinding
import com.tindeo.BryanGomezHincapie.ui.viewmodels.ProductViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class ProductDetailFragment : Fragment() {

    private var _binding: FragmentProductDetailBinding? = null
    private val binding get() = _binding!!
    private val productVIewModel: ProductViewModel by sharedViewModel()

     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_product_detail, container, false)
        _binding = FragmentProductDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        observeViewModels()
    }

    private fun observeViewModels(){
        productVIewModel.selected.observe(viewLifecycleOwner, { product ->
            binding.productDetailName.text = product.name
            binding.productDetailPrice.text = product.price
            binding.productDetailDescription.text = product.description
            Glide.with(binding.root).load(product.image).into(binding.productDetailImage)
        })
    }

}