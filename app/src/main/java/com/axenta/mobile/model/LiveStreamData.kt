package com.axenta.mobile.model

data class LiveStreamData(
    val platformName: String = "",
    val viewerCount: Int = 0,
    val revenue: Int = 0,
    val orderCount: Int = 0,
    val commentCount: Int = 0,
    val isLive: Boolean = false,
    val uptime: Long = 0
)
