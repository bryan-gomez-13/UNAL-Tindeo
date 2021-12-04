package com.tindeo.BryanGomezHincapie.data.repositories

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.tindeo.BryanGomezHincapie.data.databases.dao.ProductDao
import com.tindeo.BryanGomezHincapie.data.mocks.ProductMock
import com.tindeo.BryanGomezHincapie.data.models.Comment
import com.tindeo.BryanGomezHincapie.data.models.Product
import com.tindeo.BryanGomezHincapie.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext


class ProductRepository(private val dataSource: ProductMock, private val dataSourceDb: ProductDao, private val dataSourceFirebase: FirebaseFirestore) {

    private val db: CollectionReference = dataSourceFirebase.collection(Constants.PRODUCT_COLLECTION)

    suspend fun loadProducts(): List<Product> {
        //return dataSource.loadProduct()

       /* return withContext(Dispatchers.IO) {
            dataSourceDb.getAllProducts()
        }*/

        val snapshot = db.get().await()
        return snapshot.toObjects(Product::class.java)
    }

    suspend fun insertProducts(products: List<Product>) {
        withContext(Dispatchers.IO) {
            val temp = dataSourceDb.getAllProducts()
            if (temp.isEmpty()) {
                dataSourceDb.insertProducts(products)
            }
        }
    }
}