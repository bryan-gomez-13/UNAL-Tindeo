package com.tindeo.BryanGomezHincapie.di

import com.tindeo.BryanGomezHincapie.data.repositories.CommentRepository
import com.tindeo.BryanGomezHincapie.data.repositories.ProductRepository
import com.tindeo.BryanGomezHincapie.data.repositories.StoreRepository
import org.koin.dsl.module

val repoModule = module {
    single{StoreRepository(get(), get())}
    single { ProductRepository(get(), get()) }
    single { CommentRepository(get(), get()) }
}