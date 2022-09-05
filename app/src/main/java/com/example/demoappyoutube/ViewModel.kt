package com.example.demoappyoutube

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

const val NETWORK_PAGE_SIZE = 15

class MyViewModel: ViewModel(){
    private val repository = Repository()

    fun getList(): Flow<PagingData<MyArticle>> =
        Pager<Int, MyArticle>(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                PagingSourceInfo(repository)
            }
        ).flow.cachedIn(viewModelScope)

}