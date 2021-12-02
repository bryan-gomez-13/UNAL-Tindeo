package com.tindeo.BryanGomezHincapie.data.repositories

import com.tindeo.BryanGomezHincapie.data.databases.dao.StoreDao
import com.tindeo.BryanGomezHincapie.data.mocks.StoreInfoMock
import com.tindeo.BryanGomezHincapie.data.models.StoreInfo

//                      Este repositorio recibe el parametro de la fuente de datos que sera mockiada
class StoreRepository(private val dataSource: StoreInfoMock, private val dataSourceDb: StoreDao) {
    // fucn asyc (suspend), cargar info
    suspend fun loadInfo(): StoreInfo? {
        // llamada desde firebase o API
        // se retorna la info
        // Llamar al datasource y devuelve la info
        // El repo vera como da la infor dependiendo de donde se pida
        //return dataSource.loadInfo()
        return dataSourceDb.getStore()
    }

    suspend fun insertStore(store: StoreInfo){
        val temp = dataSourceDb.getStore()
        if(temp == null){
            dataSourceDb.insertStore(store)
        }
    }
}