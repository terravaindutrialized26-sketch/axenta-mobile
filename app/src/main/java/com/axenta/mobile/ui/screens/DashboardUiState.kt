package com.axenta.mobile.ui.screens

import com.axenta.mobile.model.LiveStreamData
import com.axenta.mobile.model.SystemMetrics

data class DashboardUiState(
    val liveStreams: List<LiveStreamData> = emptyList(),
    val systemMetrics: SystemMetrics = SystemMetrics(),
    val isLoading: Boolean = true,
    val error: String? = null
)
