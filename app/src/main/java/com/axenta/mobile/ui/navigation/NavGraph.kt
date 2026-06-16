package com.axenta.mobile.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.axenta.mobile.ui.screens.DashboardScreen
import com.axenta.mobile.ui.screens.SettingsScreen

@Composable
fun AXENTANavGraph(
    navController: NavHostController,
    startDestination: String = Screen.Dashboard.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.Dashboard.route) {
            DashboardScreen(navController)
        }
        composable(Screen.ObsControl.route) {
            DashboardScreen(navController) // Placeholder
        }
        composable(Screen.AudioMixer.route) {
            DashboardScreen(navController) // Placeholder
        }
        composable(Screen.CameraControl.route) {
            DashboardScreen(navController) // Placeholder
        }
        composable(Screen.LightingControl.route) {
            DashboardScreen(navController) // Placeholder
        }
        composable(Screen.TikTokLive.route) {
            DashboardScreen(navController) // Placeholder
        }
        composable(Screen.ShopeeLive.route) {
            DashboardScreen(navController) // Placeholder
        }
        composable(Screen.LiveHub.route) {
            DashboardScreen(navController) // Placeholder
        }
        composable(Screen.Podcast.route) {
            DashboardScreen(navController) // Placeholder
        }
        composable(Screen.MusicLive.route) {
            DashboardScreen(navController) // Placeholder
        }
        composable(Screen.Settings.route) {
            SettingsScreen(navController)
        }
    }
}

sealed class Screen(val route: String) {
    data object Dashboard : Screen("dashboard")
    data object ObsControl : Screen("obs_control")
    data object AudioMixer : Screen("audio_mixer")
    data object CameraControl : Screen("camera_control")
    data object LightingControl : Screen("lighting_control")
    data object TikTokLive : Screen("tiktok_live")
    data object ShopeeLive : Screen("shopee_live")
    data object LiveHub : Screen("live_hub")
    data object Podcast : Screen("podcast")
    data object MusicLive : Screen("music_live")
    data object Settings : Screen("settings")
}
