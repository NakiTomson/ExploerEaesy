package com.example.user.di

import android.util.Log
import com.example.user.ui.user.model.UserViewModel
import com.example.user.ui.user.view.UserFragment
import com.testtask.core_di.AppProvider
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.multibindings.ElementsIntoSet
import dagger.multibindings.IntoSet
import dagger.multibindings.Multibinds
import javax.inject.Inject

@User
@Component(dependencies = [AppProvider::class], modules = [UserViewModelFactoriesModule::class, AnalitikModule::class])
interface UserComponent {

    fun inject(fragment: UserFragment)

    fun viewModelFactory(): UserViewModel.Factory

    companion object {
        private val userComponent: UserComponent? = null
        fun create(appProvider: AppProvider): UserComponent {
            return userComponent
                ?: DaggerUserComponent
                    .builder()
                    .appProvider(appProvider)
                    .build()
        }
    }
}

@Module(includes = [AnalitikModuleTrackers::class])
interface AnalitikModule {

    @Binds
    @IntoSet
    fun bindFBTracker(analitiksFacebook: AnalitiksFacebook): AnalitiksTracker

    @Multibinds
    fun provideMultipleTracker(): Set<AnalitiksTracker>
}

@Module
class AnalitikModuleTrackers {

    @Provides
    @ElementsIntoSet
    fun provideMultipleTracker(
        analitiksFireBase: AnalitiksFireBase,
        analitiksAppMetrika: AnalitiksAppMetrika,
    ): Set<AnalitiksTracker> {
        return setOf(analitiksFireBase, analitiksAppMetrika)
    }
}


interface AnalitiksTracker {

    fun trackEent(event: Event) {
        Log.v("HEHHEHEHE", "re ${this}")
    }

    data class Event(val name: String, val value: String)
}

class AnalitiksFireBase @Inject constructor() : AnalitiksTracker {
    override fun toString(): String = "AnalitiksFireBase"
}

class AnalitiksFacebook @Inject constructor() : AnalitiksTracker {
    override fun toString(): String = "AnalitiksFacebook"
}

class AnalitiksAppMetrika @Inject constructor() : AnalitiksTracker {
    override fun toString(): String = "AnalitiksAppMetrika"
}

class Analytics @Inject constructor(private val trackers: Set<@JvmSuppressWildcards AnalitiksTracker>) {
    fun trackLogEvent(event: AnalitiksTracker.Event) {
        trackers.forEach {
            it.trackEent(event)
        }
    }
}