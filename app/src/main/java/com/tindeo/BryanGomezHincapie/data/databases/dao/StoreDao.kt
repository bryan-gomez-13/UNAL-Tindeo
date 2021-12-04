package com.tindeo.BryanGomezHincapie.data.databases.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tindeo.BryanGomezHincapie.data.models.Product
import com.tindeo.BryanGomezHincapie.data.models.StoreInfo

@Dao
interface StoreDao {
    @Insert
    fun insertStore(store: StoreInfo)

    /*@Query("SELECT * FROM stores")
    suspend fun getAllStores(): List<StoreInfo>*/

    // Traer solo una tienda
    @Query("SELECT * FROM stores LIMIT 1")
    fun getStore(): StoreInfo?
}