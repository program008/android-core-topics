package com.example.paging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn

/**
 *
 * @author liu tao
 * @date 2022/2/18 11:06
 * @description 描述
 */
class ExampleViewModel : ViewModel() {
    val flow = Pager(
        // Configure how data is loaded by passing additional properties to
        // PagingConfig, such as prefetchDistance.
        PagingConfig(pageSize = 20)
    ) {
        ExamplePagingSource()
    }.flow.cachedIn(viewModelScope)
}