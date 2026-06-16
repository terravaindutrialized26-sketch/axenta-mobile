package com.axenta.mobile.model

data class SystemMetrics(
    val cpuUsage: Int = 0,
    val ramUsage: Int = 0,
    val temperature: Int = 0,
    val uptime: Long = 0
)
