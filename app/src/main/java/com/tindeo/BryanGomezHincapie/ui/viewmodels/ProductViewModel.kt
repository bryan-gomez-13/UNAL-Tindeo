package com.tindeo.BryanGomezHincapie.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tindeo.BryanGomezHincapie.data.models.Product
import com.tindeo.BryanGomezHincapie.data.repositories.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(private val repo: ProductRepository): ViewModel() {
    private var _products: MutableLiveData<List<Product>> = MutableLiveData()
    val products: LiveData<List<Product>> get() = _products

    fun loadProducts(){
        viewModelScope.launch {
            val result = repo.loadProducts()
            _products.postValue(result)
        }
    }
}