package com.tindeo.BryanGomezHincapie.data.repositories

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.tindeo.BryanGomezHincapie.data.databases.dao.StoreDao
import com.tindeo.BryanGomezHincapie.data.mocks.StoreInfoMock
import com.tindeo.BryanGomezHincapie.data.models.StoreInfo
import com.tindeo.BryanGomezHincapie.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

//                      Este repositorio recibe el parametro de la fuente de datos que sera mockiada
class StoreRepository(private val dataSource: StoreInfoMock, private val dataSourceDb: StoreDao,private val dataSourceFirebase: FirebaseFirestore) {
    private val db: CollectionReference = dataSourceFirebase.collection(Constants.STORE_COLLECTION)

    // fucn asyc (suspend), cargar info
    suspend fun loadInfo(): StoreInfo? {
        // llamada desde firebase o API
        // se retorna la info
        // Llamar al datasource y devuelve la info
        // El repo vera como da la infor dependiendo de donde se pida
        //return dataSource.loadInfo()


        /*return withContext(Dispatchers.IO) {
            dataSourceDb.getStore()
        }*/
        val snapshot = db.get().await()
        return snapshot.toObjects(StoreInfo::class.java)[0]
    }

    suspend fun insertStore(store: StoreInfo) {
        withContext(Dispatchers.IO) {
            val temp = dataSourceDb.getStore()
            if (temp == null) {
                dataSourceDb.insertStore(store)
            }
        }
    }
}