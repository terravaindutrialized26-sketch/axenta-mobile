package com.axenta.mobile.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.axenta.mobile.ui.theme.BackgroundDark
import com.axenta.mobile.ui.theme.PrimaryBlue

@Composable
fun DashboardScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundDark),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Dashboard - Coming Soon",
            color = PrimaryBlue,
            fontSize = 24.sp
        )
    }
}
