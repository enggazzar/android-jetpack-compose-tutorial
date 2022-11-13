package com.ksi.examplecompose

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    val repository=Repository()
    var state by mutableStateOf(ScreenState())
    private val paginator = DefaultPaginator(
        initialKey = state.page,
        onLoadUpdated = {
            state = state.copy(isLoading = it)
        },
        onRequest = { nextPage ->
            repository.getItems(nextPage, 20)
        },
        getNextKey = {
            state.page + 1
        },
        onError = {
            state = state.copy(error = it?.localizedMessage)
        },
        onSuccess = { listItem, newKey ->
            state = state.copy(
                items = state.items + listItem,
                page = newKey,
                endReach = listItem.isEmpty()
            )
        }

    )
    init {
        loadNextItem()
    }
    fun loadNextItem(){
        Log.e("loadmore","moree")
        viewModelScope.launch {
            paginator.loadNextPage()
        }
    }

}
data class ScreenState(
    val isLoading:Boolean=false,
    val items:List<Item> = emptyList(),
    val error:String?=null,
    val endReach:Boolean=false,
    val page:Int=0
)