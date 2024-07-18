package com.example.chatapplication.SampleData

import com.example.chatapplication.Map.UserProfile
import com.example.chatapplication.R


    val userProfiles = listOf(
        UserProfile(
            id = "user1",
            name = "Arjun",
            age = 28,
            imageUrl = R.drawable.roman,
            languages = listOf("English", "Tamil"),
            interests = listOf("Cricket", "Reading", "Traveling"),
            aboutMe = "Hello, I'm Arjun. I enjoy playing cricket and traveling to new places. Reading is my way of unwinding after a long day."
        ),
        UserProfile(
            id = "user2",
            name = "Aarav",
            age = 23,
            imageUrl = R.drawable.sukuna,
            languages = listOf("Hindi", "English"),
            interests = listOf("Photography", "Music", "Hiking"),
            aboutMe = "Hi, I'm Aarav. I have a passion for photography and love capturing moments. Music and hiking are my other interests."
        ),
        UserProfile(
            id = "user3",
            name = "Rohan",
            age = 30,
            imageUrl = R.drawable.luffy,
            languages = listOf("English", "Marathi"),
            interests = listOf("Fitness", "Cooking", "Traveling"),
            aboutMe = "Hey, I'm Rohan. Fitness is a big part of my life. I also love to cook and explore new cuisines. Traveling is my favorite way to relax."
        ),

        UserProfile(
            id = "user4",
            name = "Ishaan",
            age = 27,
            imageUrl = R.drawable.astra,
            languages = listOf("Hindi", "Punjabi"),
            interests = listOf("Gaming", "Movies", "Technology"),
            aboutMe = "Hi there, I'm Ishaan. A tech enthusiast who loves gaming and watching movies. Always up for discussing the latest gadgets."
        ),
        UserProfile(
            id = "user5",
            name = "Kunal",
            age = 26,
            imageUrl = R.drawable.itachi,
            languages = listOf("English", "Gujarati"),
            interests = listOf("Cycling", "Music", "Art"),
            aboutMe = "Hello, I'm Kunal. I enjoy cycling and listening to music. Art is my passion and I love visiting galleries and exhibitions."
        ),
        UserProfile(
            id = "user6",
            name = "Aditi",
            age = 24,
            imageUrl = R.drawable.anna,
            languages = listOf("Hindi", "English"),
            interests = listOf("Dancing", "Traveling", "Cooking"),
            aboutMe = "Hi, I'm Aditi. Dancing is my passion and I love to travel and explore new cultures. Cooking is a way for me to express creativity."
        ),
        UserProfile(
            id = "user7",
            name = "Neha",
            age = 22,
            imageUrl = R.drawable.sudia,
            languages = listOf("English", "Bengali"),
            interests = listOf("Reading", "Yoga", "Music"),
            aboutMe = "Hey, I'm Neha. A book lover who practices yoga regularly. Music is a big part of my life and I love discovering new genres."
        ),
        UserProfile(
            id = "user8",
            name = "Siddharth",
            age = 29,
            imageUrl = R.drawable.varun,
            languages = listOf("Hindi", "Telugu"),
            interests = listOf("Football", "Movies", "Photography"),
            aboutMe = "Hello, I'm Siddharth. Football enthusiast and movie buff. I also enjoy photography and capturing beautiful moments."
        ),
        UserProfile(
            id = "user9",
            name = "Meera",
            age = 25,
            imageUrl = R.drawable.nami,
            languages = listOf("Hindi", "Kannada"),
            interests = listOf("Gardening", "Reading", "Traveling"),
            aboutMe = "Hi, I'm Meera. Gardening brings me peace and I love to read and travel. Exploring new places is always exciting for me."
        ),
        UserProfile(
            id = "user10",
            name = "Ravi",
            age = 31,
            imageUrl = R.drawable.gojo,
            languages = listOf("English", "Malayalam"),
            interests = listOf("Running", "Cooking", "Gaming"),
            aboutMe = "Hey, I'm Ravi. I enjoy running and keeping fit. Cooking is a hobby of mine and gaming is a great way for me to relax."
        )

    )

fun getlist(): List<UserProfile> {
    return userProfiles
}


fun getUserProfile(userId: String): UserProfile {
    return userProfiles.find { it.id == userId } ?: throw IllegalArgumentException("User profile not found")

}

