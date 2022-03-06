package com.sandystudios.copenhagen_add.model

data class User(
    val uid: String,
    val name: String,
    val age: Int,
    val score: Int,
    val gambleChoice: String,
    val gambleScore: Int,
    val dateAndTime: String
)
