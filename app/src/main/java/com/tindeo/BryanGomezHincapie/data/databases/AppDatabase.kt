package com.tindeo.BryanGomezHincapie.data.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tindeo.BryanGomezHincapie.data.models.Comment
import com.tindeo.BryanGomezHincapie.data.models.Product
import com.tindeo.BryanGomezHincapie.data.models.StoreInfo

// DB
// Indicar un arreglo con todas las ENTIDADES
@Database(entities = [Comment::class, Product::class, StoreInfo::class],version = 1)
// Antes de ser una db tiene que extender de RoomDatabase
abstract class AppDatabase: RoomDatabase(){
    //Funciones abstractas - Cada una devuelve cada Dao
    //17:10
}