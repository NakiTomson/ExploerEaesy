package com.testtask.core_ui.utils

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

// only one subscriber
class SingleLiveEventFlow<Event> {

    private val _singleEvent: Channel<Event?> = Channel(Channel.BUFFERED)
    val singleEvent: Flow<Event?> = _singleEvent.receiveAsFlow() // expose as flow

    suspend fun postEvent(event: Event) {
        _singleEvent.send(event) // suspends on buffer overflow
    }

    suspend fun call() {
        _singleEvent.send(null)
    }
}