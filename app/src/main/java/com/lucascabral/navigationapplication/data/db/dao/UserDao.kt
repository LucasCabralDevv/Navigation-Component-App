package com.lucascabral.navigationapplication.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lucascabral.navigationapplication.data.db.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(user: UserEntity)

    @Query("SELECT * FROM user WHERE id = :id")
    fun getUser(id: Long): UserEntity

    @Query("SELECT id FROM user WHERE username = :userName and password = :password")
    fun login(userName: String, password: String): Long
}