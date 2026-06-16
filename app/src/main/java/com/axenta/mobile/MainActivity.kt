package com.axenta.mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.axenta.mobile.ui.navigation.AXENTANavigation
import com.axenta.mobile.ui.theme.AXENTATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AXENTATheme {
                AXENTAApp()
            }
        }
    }
}

@Composable
fun AXENTAApp() {
    Surface(
        modifier = Modifier.background(Color(0xFF0A0E27)),
        color = Color(0xFF0A0E27)
    ) {
        AXENTANavigation()
    }
}
