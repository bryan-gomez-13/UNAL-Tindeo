package com.tindeo.BryanGomezHincapie.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

// Solo sera una clase de setter and getter para retorna la info de la tienda
@Entity(tableName = "stores")
data class StoreInfo (
    @PrimaryKey var id: String?,
    var name: String?,
    var image: String?,
    var address: String?,
    var description: String?,
    var lat: Double? = null,
    var lng: Double? = null,
    var match: Int?
    )