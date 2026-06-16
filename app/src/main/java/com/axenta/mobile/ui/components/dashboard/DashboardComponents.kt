package com.axenta.mobile.ui.components.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.axenta.mobile.model.LiveStreamData
import com.axenta.mobile.model.SystemMetrics
import com.axenta.mobile.ui.theme.BackgroundDarker
import com.axenta.mobile.ui.theme.PrimaryBlue
import com.axenta.mobile.ui.theme.PrimaryBlueLight
import com.axenta.mobile.ui.theme.StatusOnline
import com.axenta.mobile.ui.theme.SurfaceDark
import com.axenta.mobile.ui.theme.TextPrimary
import com.axenta.mobile.ui.theme.TextSecondary
import com.axenta.mobile.ui.theme.TextTertiary

@Composable
fun DashboardGrid(
    liveStreams: List<LiveStreamData>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "LIVE PLATFORMS",
            color = PrimaryBlue,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(liveStreams) { stream ->
                LiveStreamCard(stream)
            }
        }
    }
}

@Composable
fun LiveStreamCard(
    stream: LiveStreamData,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(140.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(SurfaceDark)
            .border(
                width = 1.dp,
                color = if (stream.isLive) PrimaryBlue else TextTertiary,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(12.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBetween
        ) {
            // Header with platform name and status
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Videocam,
                        contentDescription = null,
                        tint = if (stream.isLive) PrimaryBlue else TextTertiary,
                        modifier = Modifier
                            .size(16.dp)
                            .padding(end = 6.dp)
                    )
                    Text(
                        text = stream.platformName,
                        color = TextPrimary,
                        fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                
                // Live indicator
                if (stream.isLive) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(StatusOnline.copy(alpha = 0.3f))
                            .padding(4.dp, 2.dp)
                    ) {
                        Text(
                            text = "LIVE",
                            color = StatusOnline,
                            fontSize = 10.sp
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Metrics row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                MetricSmall(label = "Viewers", value = stream.viewerCount.toString())
                MetricSmall(label = "Revenue", value = "¥${stream.revenue}")
            }
            
            Spacer(modifier = Modifier.height(6.dp))
            
            // Second metrics row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                MetricSmall(label = "Orders", value = stream.orderCount.toString())
                MetricSmall(label = "Comments", value = stream.commentCount.toString())
            }
        }
    }
}

@Composable
fun MetricSmall(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = label,
            color = TextTertiary,
            fontSize = 10.sp
        )
        Text(
            text = value,
            color = PrimaryBlueLight,
            fontSize = 12.sp
        )
    }
}

@Composable
fun SystemMetricsSection(
    metrics: SystemMetrics,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "SYSTEM METRICS",
            color = PrimaryBlue,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            SystemMetricCard(
                label = "CPU",
                value = "${metrics.cpuUsage}%",
                modifier = Modifier.weight(1f),
                percentage = metrics.cpuUsage / 100f
            )
            SystemMetricCard(
                label = "RAM",
                value = "${metrics.ramUsage}%",
                modifier = Modifier.weight(1f),
                percentage = metrics.ramUsage / 100f
            )
            SystemMetricCard(
                label = "TEMP",
                value = "${metrics.temperature}°C",
                modifier = Modifier.weight(1f),
                percentage = (metrics.temperature / 100f).coerceIn(0f, 1f)
            )
        }
    }
}

@Composable
fun SystemMetricCard(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    percentage: Float = 0f
) {
    val statusColor = when {
        percentage > 0.9f -> Color(0xFFFF3333) // Error
        percentage > 0.75f -> Color(0xFFFF6B00) // Warning
        else -> PrimaryBlue // Normal
    }
    
    Box(
        modifier = modifier
            .height(100.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(SurfaceDark)
            .border(
                width = 1.dp,
                color = statusColor.copy(alpha = 0.5f),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(12.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = label,
                color = TextTertiary,
                fontSize = 11.sp
            )
            
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = value,
                    color = statusColor,
                    fontSize = 18.sp
                )
            }
            
            // Progress bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(TextTertiary.copy(alpha = 0.2f))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(percentage)
                        .height(4.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(statusColor)
                )
            }
        }
    }
}
