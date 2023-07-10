package com.example.growighassignment.modelClasses

data class Result(
    val created_at: String,
    val description: String,
    val id: String,
    val liked_by_user: Boolean,
    val likes: Int,
    val urls: UrlsX,
)