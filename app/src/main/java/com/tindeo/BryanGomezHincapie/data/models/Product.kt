package com.tindeo.BryanGomezHincapie.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

//pollos POJO
//Clase que solo tiene informacion - Getters and setter
@Entity(tableName = "products")
data class Product(
    @PrimaryKey var id: String = "",
    var name: String?,
    var description: String?,
    var price: String?,
    var image: String?
)