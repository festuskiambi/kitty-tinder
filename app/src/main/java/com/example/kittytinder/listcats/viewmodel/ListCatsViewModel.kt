package com.example.kittytinder.listcats.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kittytinder.common.BaseViewModel
import com.example.kittytinder.data.CatImage
import com.example.kittytinder.data.source.ICatsDataSource
import com.example.kittytinder.listcats.ListCatEvent
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 * Created by Festus Kiambi on 6/15/19.
 */
class ListCatsViewModel(
    val catsDataSource: ICatsDataSource,
    uiContext: CoroutineContext
) : BaseViewModel<ListCatEvent>(uiContext) {

    private val catsListState = MutableLiveData<List<CatImage>>()
    val catsList: LiveData<List<CatImage>> get() = catsListState

    override fun handleEvent(event: ListCatEvent) {
        when(event){
            is ListCatEvent.OnStart -> getCatsList()
        }
    }

    private fun getCatsList() = launch {
        val result =  catsDataSource.getCatImages()
        catsListState.value = result
    }
}