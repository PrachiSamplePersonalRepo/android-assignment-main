package com.adyen.android.assignment.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.adyen.android.assignment.api.model.AstronomyPicture
import com.adyen.android.assignment.api.network.ApiService
import com.adyen.android.assignment.api.repo.PostsDataSource
import kotlinx.coroutines.Dispatchers


class MainViewModel(val apiService: ApiService) : ViewModel() {
    var postsLiveData: LiveData<PagedList<AstronomyPicture>>

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(30)
            .setEnablePlaceholders(false)
            .build()
        postsLiveData = initializedPagedListBuilder(config).build()
    }

    fun getPosts(): LiveData<PagedList<AstronomyPicture>> = postsLiveData

    private fun initializedPagedListBuilder(config: PagedList.Config):
            LivePagedListBuilder<String, AstronomyPicture> {

        val dataSourceFactory = object : DataSource.Factory<String, AstronomyPicture>() {
            override fun create(): DataSource<String, AstronomyPicture> {
                return PostsDataSource(Dispatchers.IO, apiService)
            }
        }
        return LivePagedListBuilder<String, AstronomyPicture>(dataSourceFactory, config)
    }
}