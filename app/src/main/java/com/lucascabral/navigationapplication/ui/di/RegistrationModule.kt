package com.lucascabral.navigationapplication.ui.di

import com.lucascabral.navigationapplication.data.db.AppDatabase
import com.lucascabral.navigationapplication.data.repository.UserDbDataSource
import com.lucascabral.navigationapplication.data.repository.UserRepository
import com.lucascabral.navigationapplication.ui.registration.RegistrationViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val registrationModule = module {

    single<UserRepository> {
        val db = AppDatabase.getDatabase(androidContext())
        UserDbDataSource(db.userDao())
    }

    viewModel {
        RegistrationViewModel(
            userRepository = get()
        )
    }
}