package com.example.hwanportfolio

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform