package com.example.chatapplication.Map

data class UserProfile(
    val id: String,
    val name: String,
    val age: Int,
    val imageUrl: Int, // Or use an Int for drawable resources
    val languages: List<String>,
    val interests: List<String>,
    val aboutMe: String
)