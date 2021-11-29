package com.tindeo.BryanGomezHincapie.data.repositories

import com.tindeo.BryanGomezHincapie.data.mocks.ProductMock
import com.tindeo.BryanGomezHincapie.data.models.Product


class ProductRepository(private val dataSource: ProductMock) {
    suspend fun loadProducts(): List<Product>{
        return dataSource.loadProduct()
    }
}