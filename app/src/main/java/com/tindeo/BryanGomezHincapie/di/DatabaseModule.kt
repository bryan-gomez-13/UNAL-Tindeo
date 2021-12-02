package com.tindeo.BryanGomezHincapie.di

import com.tindeo.BryanGomezHincapie.data.databases.AppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single {AppDatabase.getInstance(get())}
    // esto es con koin que permite traer la info
    single { get<AppDatabase>().commentDao() }
    single { get<AppDatabase>().productDao() }
    single { get<AppDatabase>().storeDAo() }
}
