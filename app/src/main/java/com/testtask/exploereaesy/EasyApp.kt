package com.testtask.exploereaesy

import android.app.Application
import com.testtask.core_di.AppProvider
import com.testtask.core_di.ApplicationProvider
import com.testtask.exploereaesy.di.AppComponent
import com.testtask.exploereaesy.di.ConfigurationComponent
import com.testtask.exploereaesy.di.ContextComponent
import com.testtask.interactors_impl.di.InteractorsComponent
import com.testtask.network_impl.di.NetworkComponent
import com.testtask.persistence_impl.di.PersistenceComponent
import com.testtask.repositories_impl.di.RepositoriesComponent

class EasyApp : Application(), ApplicationProvider {

    override lateinit var appProvider: AppProvider

    override fun onCreate() {
        super.onCreate()
        setupDI()
    }

    private fun setupDI() {
        val contextComponent = ContextComponent.create(this)
        val configurationComponent = ConfigurationComponent.create(contextComponent)

        val networkComponent = NetworkComponent.create(
            contextComponent,
            configurationComponent
        )
        val persistenceComponent = PersistenceComponent.create(contextComponent, configurationComponent, networkComponent)
        val repositoriesComponent = RepositoriesComponent.create(
            networkComponent,
            contextComponent,
            persistenceComponent
        )
        val interactorsComponent = InteractorsComponent.create(
            repositoriesComponent,
        )
        appProvider = AppComponent.create(
            contextComponent,
            networkComponent,
            repositoriesComponent,
            interactorsComponent,
            persistenceComponent
        )
    }
}