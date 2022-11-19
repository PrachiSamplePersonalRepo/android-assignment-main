package com.adyen.android.assignment.di.module


import com.adyen.android.assignment.ui.viewmodel.AstronomyPictureListViewModel
import com.adyen.android.assignment.ui.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        AstronomyPictureListViewModel(get())
    }
    viewModel {
        MainViewModel(get())
    }
}