package com.example.basicroomapp.database

class User(
     user_id: String,
     user_name: String,
     user_height: Double,
     user_weight: Double,
     user_email: String,
     user_pass: String
) {

    val user_id: String = user_id
    val user_name: String =user_name
    val user_height: Double = user_height
    val user_weight: Double = user_height
    val user_email: String = user_email
    val user_pass: String = user_pass


}

fun User.toEntity() = UserEntity(
    user_id,
    user_name,
    user_height,
    user_weight,
    user_email,
    user_pass
)