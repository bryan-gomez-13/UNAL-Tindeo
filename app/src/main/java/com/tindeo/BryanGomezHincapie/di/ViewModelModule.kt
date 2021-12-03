package com.tindeo.BryanGomezHincapie.di

import com.tindeo.BryanGomezHincapie.data.repositories.UserRepository
import com.tindeo.BryanGomezHincapie.ui.viewmodels.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module{
    viewModel{ StoreViewModel(get())}
    viewModel{ ProductViewModel(get())}
    viewModel{ CommentViewModel(get())}
    viewModel { SplashViewModel(get(),get(),get()) }
    viewModel { LoginViewModel(get()) }
}