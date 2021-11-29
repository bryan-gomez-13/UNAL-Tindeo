package com.tindeo.BryanGomezHincapie.data.models
// modelo
data class Comment(
    var id: String,
    var author: String,
    var title: String,
    var description: String,
    var data: String,
    var image: String,
    var like: Int,
    var unlike: Int,
    var rating: Int,
)
