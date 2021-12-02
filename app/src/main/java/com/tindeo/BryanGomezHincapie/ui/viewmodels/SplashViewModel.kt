package com.tindeo.BryanGomezHincapie.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tindeo.BryanGomezHincapie.data.models.Comment
import com.tindeo.BryanGomezHincapie.data.models.Product
import com.tindeo.BryanGomezHincapie.data.models.StoreInfo
import com.tindeo.BryanGomezHincapie.data.repositories.CommentRepository
import com.tindeo.BryanGomezHincapie.data.repositories.ProductRepository
import com.tindeo.BryanGomezHincapie.data.repositories.StoreRepository
import kotlinx.coroutines.launch

class SplashViewModel(private val repoStore: StoreRepository, private val repoComment: CommentRepository,
    private val repoProduct: ProductRepository): ViewModel() {
        fun insert(store: StoreInfo, comments: List<Comment>, products: List<Product>){
            viewModelScope.launch {
                repoStore.insertStore(store)
                repoComment.insertComments(comments)
                repoProduct.insertProducts(products)
            }
        }
}