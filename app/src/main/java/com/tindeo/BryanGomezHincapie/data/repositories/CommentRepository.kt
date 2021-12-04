package com.tindeo.BryanGomezHincapie.data.repositories

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.tindeo.BryanGomezHincapie.data.databases.dao.CommentDao
import com.tindeo.BryanGomezHincapie.data.mocks.CommentMock
import com.tindeo.BryanGomezHincapie.data.models.Comment
import com.tindeo.BryanGomezHincapie.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

//                      mock                                Sql lite
class CommentRepository(private val dataSource:CommentMock,
                        private val dataSourceDb: CommentDao,
                        private val dataSourceFirebase: FirebaseFirestore) {

    private val db: CollectionReference = dataSourceFirebase.collection(Constants.COMMENT_COLLECTION)

    suspend fun loadComments(): List<Comment> {
        //Mock
        //return dataSource.loadComments()

        //Room - SQl lite
       /* return withContext(Dispatchers.IO) {
            dataSourceDb.getAllComments()
        }*/
        val snapshot = db.get().await()
        return snapshot.toObjects(Comment::class.java)
    }

    suspend fun insertComments(comments: List<Comment>) {
        withContext(Dispatchers.IO) {
            val temp = dataSourceDb.getAllComments()
            if (temp.isEmpty()) {
                dataSourceDb.insertComments(comments)
            }
        }
    }
}