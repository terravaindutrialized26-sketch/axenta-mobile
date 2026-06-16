package com.axenta.mobile.data

import com.axenta.mobile.model.LiveStreamData
import com.axenta.mobile.model.SystemMetrics
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class DemoDashboardService {
    private var isRunning = true
    
    fun simulateLiveStreams(): Flow<List<LiveStreamData>> = flow {
        val platforms = listOf(
            "TikTok Live",
            "Shopee Live",
            "YouTube Live",
            "Instagram Live"
        )
        
        while (isRunning) {
            val streams = platforms.map { platform ->
                LiveStreamData(
                    platformName = platform,
                    viewerCount = Random.nextInt(100, 50000),
                    revenue = Random.nextInt(100, 5000),
                    orderCount = Random.nextInt(5, 200),
                    commentCount = Random.nextInt(50, 2000),
                    isLive = Random.nextBoolean() || true  // Most platforms stay live
                )
            }
            emit(streams)
            delay(2000) // Update every 2 seconds
        }
    }
    
    fun simulateSystemMetrics(): Flow<SystemMetrics> = flow {
        while (isRunning) {
            val metrics = SystemMetrics(
                cpuUsage = Random.nextInt(10, 95),
                ramUsage = Random.nextInt(20, 90),
                temperature = Random.nextInt(35, 85),
                uptime = System.currentTimeMillis() / 1000
            )
            emit(metrics)
            delay(1500) // Update every 1.5 seconds
        }
    }
    
    fun stop() {
        isRunning = false
    }
}
