package com.adyen.android.assignment.api.repo

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.adyen.android.assignment.api.model.AstronomyPicture
import com.adyen.android.assignment.api.network.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class PostsDataSource(coroutineContext: CoroutineContext, private val apiService: ApiService) :
    PageKeyedDataSource<String, AstronomyPicture>() {

    private val job = Job()
    private val scope = CoroutineScope(coroutineContext + job)

    override fun loadInitial(
        params: LoadInitialParams<String>,
        callback: LoadInitialCallback<String, AstronomyPicture>
    ) {
        scope.launch {
            try {
                val response = apiService.getPictures()
                when {
                    response.isSuccessful -> {
                        val listing = response.body()?.data
                        val redditPosts = listing?.children?.map { it.data }
                        callback.onResult(redditPosts ?: listOf(), listing?.before, listing?.after)
                    }
                }

            } catch (exception: Exception) {
                Log.e("PostsDataSource", "Failed to fetch data!")
            }

        }

    }

    override fun invalidate() {
        super.invalidate()
        job.cancel()

    }

    override fun loadAfter(
        params: LoadParams<String>,
        callback: LoadCallback<String, AstronomyPicture>
    ) {
        scope.launch {
            try {
                val response =
                    apiService.getPictures()
                when {
                    response.isSuccessful -> {
                        val listing = response.body()?.data
                        val items = listing?.children?.map { it.data }
                        callback.onResult(items ?: listOf(), listing?.after)
                    }
                }

            } catch (exception: Exception) {
                Log.e("PostsDataSource", "Failed to fetch data!")
            }
        }

    }

    override fun loadBefore(
        params: LoadParams<String>,
        callback: LoadCallback<String, AstronomyPicture>
    ) {
        scope.launch {
            try {
                val response =
                    apiService.getPictures()
                when {
                    response.isSuccessful -> {
                        val listing = response.body()?.data
                        val items = listing?.children?.map { it.data }
                        callback.onResult(items ?: listOf(), listing?.after)
                    }
                }

            } catch (exception: Exception) {
                Log.e("PostsDataSource", "Failed to fetch data!")
            }
        }

    }

}