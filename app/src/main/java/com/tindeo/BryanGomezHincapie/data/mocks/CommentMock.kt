package com.tindeo.BryanGomezHincapie.data.mocks

import com.tindeo.BryanGomezHincapie.data.models.Comment

class CommentMock {
    fun loadComments(): List<Comment> {
        // devuelve los datos quemados o de firebase o una API
        return listOf(
            Comment("1","Bryan Gomez","Good store","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","27-11-2021","https://cdn.pixabay.com/photo/2014/05/05/19/52/charcuterie-338498_960_720.jpg",70,10,5),
            Comment("2","Carlos Vesga","Bad store","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","26-11-2021","https://cdn.pixabay.com/photo/2014/05/05/19/52/charcuterie-338498_960_720.jpg",10,70,1),
            Comment("3","Sisa","So so store","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","25-11-2021","https://cdn.pixabay.com/photo/2014/05/05/19/52/charcuterie-338498_960_720.jpg",50,50,3)
        )
    }
}