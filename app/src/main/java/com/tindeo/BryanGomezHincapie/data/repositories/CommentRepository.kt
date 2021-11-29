package com.tindeo.BryanGomezHincapie.data.repositories

import com.tindeo.BryanGomezHincapie.data.models.Comment

class CommentRepository(private val dataSource:CommentRepository) {
    suspend fun loadComments(): List<Comment>{
        return dataSource.loadComments()
    }
}