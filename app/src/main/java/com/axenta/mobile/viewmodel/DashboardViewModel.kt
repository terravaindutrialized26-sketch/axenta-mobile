package com.axenta.mobile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axenta.mobile.data.DemoDashboardService
import com.axenta.mobile.ui.screens.DashboardUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {
    private val dashboardService = DemoDashboardService()
    
    private val _uiState = MutableStateFlow(DashboardUiState())
    val uiState: StateFlow<DashboardUiState> = _uiState
    
    fun startSimulation() {
        viewModelScope.launch {
            dashboardService.simulateLiveStreams().collect { liveStreams ->
                _uiState.value = _uiState.value.copy(
                    liveStreams = liveStreams
                )
            }
        }
        
        viewModelScope.launch {
            dashboardService.simulateSystemMetrics().collect { metrics ->
                _uiState.value = _uiState.value.copy(
                    systemMetrics = metrics
                )
            }
        }
    }
    
    override fun onCleared() {
        super.onCleared()
        dashboardService.stop()
    }
}
