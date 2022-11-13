package com.ksi.examplecompose

interface Paginator<key,item> {
   suspend fun loadNextPage()
   suspend fun reset()
}