package com.tindeo.BryanGomezHincapie.di

import com.tindeo.BryanGomezHincapie.data.mocks.CommentMock
import com.tindeo.BryanGomezHincapie.data.mocks.ProductMock
import com.tindeo.BryanGomezHincapie.data.mocks.StoreInfoMock
import org.koin.dsl.module

// Insertor de dependencias
val dataSourceModule = module{
    single {CommentMock()}
    single {ProductMock()}
    single {StoreInfoMock()}
}