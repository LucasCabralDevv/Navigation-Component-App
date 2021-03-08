package com.lucascabral.navigationapplication.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lucascabral.navigationapplication.data.model.User
import com.lucascabral.navigationapplication.ui.registration.RegistrationViewParams

@Entity(tableName = "user")
data class UserEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val bio: String,
    val username: String,
    val password: String
)

fun RegistrationViewParams.toUserEntity(): UserEntity {
    return UserEntity(
                name = this.name,
                bio = this.bio,
                username = this.username,
                password = this.password
            )
}

fun UserEntity.toUser(): User {
    return User(
        id = this.id.toString(),
        name = this.name,
        bio = this.bio
    )
}