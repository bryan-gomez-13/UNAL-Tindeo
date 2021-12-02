package com.tindeo.BryanGomezHincapie.data.databases.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tindeo.BryanGomezHincapie.data.models.Comment

// FIrmas de los metodos para hacer - Querys e inserciones
@Dao
interface CommentDao {
    // Si quiero insertar solo se le coloca esto
    //Como se usan corutinas se usa suspend -- Internamente inserta
    @Insert
    suspend fun insertComments(comments: List<Comment>)

    // Consultar
    @Query("SELECT * FROM comments")
    suspend fun getAllComments(): List<Comment>

    // Insertar parametro para filtros
    // @Query("SELECT * FROM comments WHERE author = :param1")
    // suspend fun getAllComments(param1: String): List<Comment>
}