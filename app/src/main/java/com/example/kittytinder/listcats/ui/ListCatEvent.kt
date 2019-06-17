package com.example.kittytinder.listcats.ui

import com.yuyakaido.android.cardstackview.Direction

/**
 * Created by Festus Kiambi on 6/15/19.
 */
sealed class ListCatEvent {
    object OnStart : ListCatEvent()
    data class OnSwipe(val position : Int, val direction: Direction?): ListCatEvent()
}