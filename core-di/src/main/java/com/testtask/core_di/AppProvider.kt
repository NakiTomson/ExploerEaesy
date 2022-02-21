package com.testtask.core_di

interface AppProvider :
    ContextProvider,
    InteractorsProvider,
    RepositoryProvider,
    NetworkProvider,
    PersistenceProvider,
    FeatureApisProvider