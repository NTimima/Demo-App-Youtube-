package com.example.demoappyoutube

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.HttpException
import java.io.IOException
import java.time.LocalDateTime
import java.util.Collections.max

class PagingSourceInfo(
    private val serverRepository: Repository
    ) : PagingSource<Int, MyArticle>() {

    var count = 0

        override fun getRefreshKey(state: PagingState<Int, MyArticle>): Int? {
            return state.anchorPosition?.let { anchorPosition ->
                state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                    ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
            }
        }

        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MyArticle> {
            val pageIndex = params.key ?: 1
            return try {
                val response = serverRepository.getListServer(params.loadSize)
                Log.d("TAG_TEST", response.size.toString())
                val nextKey =
                    if (response.isEmpty()) {
                        null
                    } else {
                        // By default, initial load size = 3 * NETWORK PAGE SIZE
                        pageIndex + (params.loadSize / NETWORK_PAGE_SIZE)
                    }
                LoadResult.Page(
                    data = response,
                    prevKey = if (pageIndex == 1) null else pageIndex,
                    nextKey = nextKey
                )
            } catch (exception: IOException) {
                return LoadResult.Error(exception)
            } catch (exception: HttpException) {
                return LoadResult.Error(exception)
            }
        }


    }