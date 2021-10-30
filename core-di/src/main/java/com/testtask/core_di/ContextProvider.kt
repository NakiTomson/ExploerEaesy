package com.testtask.core_di

import android.content.Context


interface ContextProvider {

    fun provideContext(): Context
}