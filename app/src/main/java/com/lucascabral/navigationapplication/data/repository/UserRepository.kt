package com.lucascabral.navigationapplication.data.repository

import com.lucascabral.navigationapplication.data.model.User
import com.lucascabral.navigationapplication.ui.registration.RegistrationViewParams

interface UserRepository {

    fun createUser(registrationViewParams: RegistrationViewParams)

    fun getUser(id: Long): User

    fun login(username: String, password: String): Long
}