package com.tindeo.BryanGomezHincapie.di

import com.tindeo.BryanGomezHincapie.data.databases.AppDatabase
import org.koin.dsl.module

//Inyector de dependencias
// esto es con koin que permite traer la info
val databaseModule = module {
    single {AppDatabase.getInstance(get())}
    single { get<AppDatabase>().commentDao() }
    single { get<AppDatabase>().productDao() }
    single { get<AppDatabase>().storeDao() }
}
