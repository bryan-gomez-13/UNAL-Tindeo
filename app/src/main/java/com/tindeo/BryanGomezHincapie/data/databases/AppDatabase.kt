package com.tindeo.BryanGomezHincapie.data.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tindeo.BryanGomezHincapie.data.databases.dao.CommentDao
import com.tindeo.BryanGomezHincapie.data.databases.dao.ProductDao
import com.tindeo.BryanGomezHincapie.data.databases.dao.StoreDao
import com.tindeo.BryanGomezHincapie.data.models.Comment
import com.tindeo.BryanGomezHincapie.data.models.Product
import com.tindeo.BryanGomezHincapie.data.models.StoreInfo

// DB
// Indicar un arreglo con todas las ENTIDADES
// ::class Accediendo directamente a al referencia
@Database(entities = [Comment::class, Product::class, StoreInfo::class],version = 1)
// Antes de ser una db tiene que extender de RoomDatabase
abstract class AppDatabase: RoomDatabase(){
    //Funciones abstractas - Cada una devuelve cada Dao
    abstract fun commentDao(): CommentDao
    abstract fun productDao(): ProductDao
    abstract fun storeDAo(): StoreDao

    //Singleton - Patron de diseño para tener una instancia unica - Una sola conexion
    // Crear solo una instancia

    // PATRON DE DISEÑO SINGLETON Y BUILDER
    companion object{
        @Volatile
        private var instance: AppDatabase? = null
        //Devolver la data
        fun getInstance(context: Context): AppDatabase{
            //Hilos - Dos hilos al crear una instancia se bloquea
            if(instance == null){
                synchronized(this){
                    instance = Room.databaseBuilder(context.applicationContext,AppDatabase::class.java, "example.db")
                        .build()
                }
            }
            return instance!!
        }
    }
}