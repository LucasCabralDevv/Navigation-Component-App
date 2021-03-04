package com.lucascabral.navigationapplication.data.repository

import com.lucascabral.navigationapplication.data.db.dao.UserDao
import com.lucascabral.navigationapplication.data.db.toUser
import com.lucascabral.navigationapplication.data.db.toUserEntity
import com.lucascabral.navigationapplication.data.model.User
import com.lucascabral.navigationapplication.ui.registration.RegistrationViewParams

class UserDbDataSource(
    private val userDao: UserDao
) : UserRepository {
    override suspend fun createUser(registrationViewParams: RegistrationViewParams) {
        val userEntity = registrationViewParams.toUserEntity()
        userDao.save(userEntity)
    }

    override fun getUser(id: Long): User {
        return userDao.getUser(id).toUser()
    }

    override fun login(username: String, password: String): Long {
        return userDao.login(username, password)
    }
}