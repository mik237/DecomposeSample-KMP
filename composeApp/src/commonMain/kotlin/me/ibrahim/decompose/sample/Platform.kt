package me.ibrahim.decompose.sample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform