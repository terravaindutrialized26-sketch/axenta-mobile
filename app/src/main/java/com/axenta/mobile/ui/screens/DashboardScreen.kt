package com.axenta.mobile.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.axenta.mobile.ui.components.dashboard.DashboardGrid
import com.axenta.mobile.ui.components.dashboard.SystemMetricsSection
import com.axenta.mobile.ui.theme.BackgroundDark
import com.axenta.mobile.ui.theme.PrimaryBlue
import com.axenta.mobile.ui.theme.TextPrimary
import com.axenta.mobile.viewmodel.DashboardViewModel

@Composable
fun DashboardScreen(
    navController: NavHostController,
    viewModel: DashboardViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    
    LaunchedEffect(Unit) {
        viewModel.startSimulation()
    }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundDark)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // Header
            Text(
                text = "AXENTA Dashboard",
                color = PrimaryBlue,
                style = androidx.compose.material3.MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(bottom = 24.dp)
            )
            
            // Live Platforms Grid
            DashboardGrid(
                liveStreams = uiState.liveStreams,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            )
            
            // System Metrics Section
            SystemMetricsSection(
                metrics = uiState.systemMetrics,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            )
            
            // Footer spacing
            Box(modifier = Modifier.padding(bottom = 16.dp))
        }
    }
}
