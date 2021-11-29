package com.tindeo.BryanGomezHincapie.data.models

// Solo sera una clase de setter and getter para retorna la info de la tienda
data class StoreInfo (
    var id: String,
    var name: String,
    var image: String,
    var address: String,
    var description: String,
    var lat: Double? = null,
    var lng: Double? = null,
    var match: Int,
    )