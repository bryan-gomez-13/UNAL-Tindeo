package com.tindeo.BryanGomezHincapie.data.repositories

import com.tindeo.BryanGomezHincapie.data.databases.dao.CommentDao
import com.tindeo.BryanGomezHincapie.data.mocks.CommentMock
import com.tindeo.BryanGomezHincapie.data.models.Comment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//                      mock                                Sql lite
class CommentRepository(private val dataSource:CommentMock, private val dataSourceDb: CommentDao) {
    suspend fun loadComments(): List<Comment>{
        //Mock
        //return dataSource.loadComments()
        //Room - SQl lite
        return dataSourceDb.getAllComments()
    }

    suspend fun insertComments(comments: List<Comment>){
        val temp = dataSourceDb.getAllComments()
        if(temp.isEmpty()){
            dataSourceDb.insertComments(comments)
        }
    }
}