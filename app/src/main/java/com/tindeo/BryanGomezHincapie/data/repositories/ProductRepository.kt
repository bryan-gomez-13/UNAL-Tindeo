package com.tindeo.BryanGomezHincapie.data.repositories

import com.tindeo.BryanGomezHincapie.data.databases.dao.ProductDao
import com.tindeo.BryanGomezHincapie.data.mocks.ProductMock
import com.tindeo.BryanGomezHincapie.data.models.Product


class ProductRepository(private val dataSource: ProductMock, private val dataSourceDb: ProductDao) {
    suspend fun loadProducts(): List<Product>{
        //return dataSource.loadProduct()
        return dataSourceDb.getAllProducts()
    }

    suspend fun insertProducts(products: List<Product>){
        val temp = dataSourceDb.getAllProducts()
        if(temp.isEmpty()){
            dataSourceDb.insertProducts(products)
        }
    }
}