package com.tindeo.BryanGomezHincapie.di

import com.tindeo.BryanGomezHincapie.ui.viewmodels.CommentViewModel
import com.tindeo.BryanGomezHincapie.ui.viewmodels.ProductViewModel
import com.tindeo.BryanGomezHincapie.ui.viewmodels.StoreViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module{
    viewModel{ StoreViewModel(get())}
    viewModel{ ProductViewModel(get())}
    viewModel{ CommentViewModel(get())}
}