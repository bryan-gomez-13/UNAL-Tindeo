package com.tindeo.BryanGomezHincapie.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

// Primer requerimiento - MODELOS
// Segundo              - LOS DAO
// Tercero              - Crear la db -- AppDatabase
// Anotaciones para Tidi - Etiquetas
@Entity(tableName = "comments")
data class Comment(
    @PrimaryKey var id: String = "",
    var author: String?,
    var title: String?,
    var description: String?,
    var data: String?,
    var image: String?,
    var like: Int?,
    var unlike: Int?,
    var rating: Int?
)
