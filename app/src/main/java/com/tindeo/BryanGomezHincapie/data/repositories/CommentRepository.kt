package com.tindeo.BryanGomezHincapie.data.repositories

import com.tindeo.BryanGomezHincapie.data.mocks.CommentMock
import com.tindeo.BryanGomezHincapie.data.models.Comment

class CommentRepository(private val dataSource:CommentMock) {
    suspend fun loadComments(): List<Comment>{
        return dataSource.loadComments()
    }
}