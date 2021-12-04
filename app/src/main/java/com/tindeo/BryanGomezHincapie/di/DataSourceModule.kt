package com.tindeo.BryanGomezHincapie.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.tindeo.BryanGomezHincapie.data.mocks.CommentMock
import com.tindeo.BryanGomezHincapie.data.mocks.ProductMock
import com.tindeo.BryanGomezHincapie.data.mocks.StoreInfoMock
import org.koin.dsl.module

// Insertor de dependencias
val dataSourceModule = module{
    single {CommentMock()}
    single {ProductMock()}
    single {StoreInfoMock()}
    single { FirebaseAuth.getInstance()}
    single { FirebaseStorage.getInstance().getReference()}
    single { FirebaseFirestore.getInstance() }
}