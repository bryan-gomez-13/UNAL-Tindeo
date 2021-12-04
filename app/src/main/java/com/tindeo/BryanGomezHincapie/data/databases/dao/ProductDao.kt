package com.tindeo.BryanGomezHincapie.data.databases.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tindeo.BryanGomezHincapie.data.models.Product

@Dao
interface ProductDao {
    @Insert
    fun insertProducts(products: List<Product>)

    @Query("SELECT * FROM products")
    fun getAllProducts(): List<Product>
}