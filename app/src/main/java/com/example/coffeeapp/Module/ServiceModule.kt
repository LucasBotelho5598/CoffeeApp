package com.notes.app.model.service.module

import com.example.coffeeapp.Impl.AccountServiceImpl
import com.example.coffeeapp.Services.AccountService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {
    @Binds abstract fun provideAccountService(impl: AccountServiceImpl): AccountService

}