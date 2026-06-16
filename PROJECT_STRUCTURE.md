# AXENTA Mobile - Complete Project Structure

## Directory Tree

```
axenta-mobile/
├── app/
│   ├── build.gradle.kts
│   ├── proguard-rules.pro
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml
│           ├── java/com/axenta/mobile/
│           │   ├── MainActivity.kt
│           │   ├── ui/
│           │   │   ├── theme/
│           │   │   │   ├── Color.kt
│           │   │   │   ├── Theme.kt
│           │   │   │   └── Type.kt
│           │   │   ├── screens/
│           │   │   │   ├── DashboardScreen.kt
│           │   │   │   ├── ObsControlScreen.kt
│           │   │   │   ├── AudioMixerScreen.kt
│           │   │   │   ├── CameraControlScreen.kt
│           │   │   │   ├── LightingControlScreen.kt
│           │   │   │   ├── TikTokLiveScreen.kt
│           │   │   │   ├── ShopeeLiveScreen.kt
│           │   │   │   ├── LiveHubScreen.kt
│           │   │   │   ├── PodcastScreen.kt
│           │   │   │   ├── MusicLiveScreen.kt
│           │   │   │   └── SettingsScreen.kt
│           │   │   └── components/
│           │   │       ├── StatCard.kt
│           │   │       ├── LiveMetricCard.kt
│           │   │       ├── SystemMetricCard.kt
│           │   │       ├── ControlButton.kt
│           │   │       ├── SliderControl.kt
│           │   │       ├── ToggleSwitch.kt
│           │   │       ├── BottomNavigation.kt
│           │   │       └── NavigationGraph.kt
│           │   ├── viewmodel/
│           │   │   ├── MainViewModel.kt
│           │   │   ├── DashboardViewModel.kt
│           │   │   ├── LiveStreamViewModel.kt
│           │   │   ├── SystemMetricsViewModel.kt
│           │   │   ├── AudioMixerViewModel.kt
│           │   │   ├── CameraControlViewModel.kt
│           │   │   ├── LightingControlViewModel.kt
│           │   │   └── SettingsViewModel.kt
│           │   ├── model/
│           │   │   ├── LiveStreamData.kt
│           │   │   ├── SystemMetrics.kt
│           │   │   ├── AudioChannel.kt
│           │   │   ├── CameraState.kt
│           │   │   ├── LightingState.kt
│           │   │   └── PlatformStatus.kt
│           │   └── data/
│           │       ├── DemoDataService.kt
│           │       ├── SimulationEngine.kt
│           │       ├── LiveStreamSimulator.kt
│           │       ├── SystemMetricsSimulator.kt
│           │       └── AudioLevelSimulator.kt
│           └── res/
│               ├── values/
│               │   ├── colors.xml
│               │   ├── strings.xml
│               │   ├── themes.xml
│               │   └── dimens.xml
│               ├── drawable/
│               │   └── ic_launcher_background.xml
│               └── mipmap/
│                   ├── ic_launcher.xml
│                   └── ic_launcher_round.xml
├── build.gradle.kts
├── settings.gradle.kts
├── .gitignore
└── README.md
```

## File Breakdown by Category

### **Core Setup (3 files)**
- `build.gradle.kts` (root)
- `settings.gradle.kts`
- `app/build.gradle.kts`

### **Android Configuration (3 files)**
- `AndroidManifest.xml`
- `themes.xml`
- `strings.xml`

### **UI Theme (3 files)**
- `Color.kt` - Blue Neon color palette
- `Theme.kt` - Material 3 dark theme
- `Type.kt` - Typography setup

### **Screens (11 files)**
- `DashboardScreen.kt` - Main overview
- `ObsControlScreen.kt` - OBS demo controls
- `AudioMixerScreen.kt` - Audio levels & mixing
- `CameraControlScreen.kt` - Camera status & control
- `LightingControlScreen.kt` - Lighting controls
- `TikTokLiveScreen.kt` - TikTok live metrics
- `ShopeeLiveScreen.kt` - Shopee live metrics
- `LiveHubScreen.kt` - Unified live hub
- `PodcastScreen.kt` - Podcast metrics
- `MusicLiveScreen.kt` - Music live metrics
- `SettingsScreen.kt` - App settings

### **Reusable Components (7 files)**
- `StatCard.kt` - Display statistics
- `LiveMetricCard.kt` - Live stream metrics
- `SystemMetricCard.kt` - System resources
- `ControlButton.kt` - Interactive buttons
- `SliderControl.kt` - Value adjusters
- `ToggleSwitch.kt` - On/off controls
- `BottomNavigation.kt` - Screen navigation
- `NavigationGraph.kt` - Navigation setup

### **ViewModels (8 files)**
- `MainViewModel.kt` - App-wide state
- `DashboardViewModel.kt` - Dashboard data
- `LiveStreamViewModel.kt` - Live stream unified data
- `SystemMetricsViewModel.kt` - CPU, RAM, Temp
- `AudioMixerViewModel.kt` - Audio channels
- `CameraControlViewModel.kt` - Camera state
- `LightingControlViewModel.kt` - Lighting state
- `SettingsViewModel.kt` - User preferences

### **Data Models (6 files)**
- `LiveStreamData.kt` - Platform-agnostic live data
- `SystemMetrics.kt` - CPU, RAM, Temperature
- `AudioChannel.kt` - Individual audio tracks
- `CameraState.kt` - Camera properties
- `LightingState.kt` - Lighting properties
- `PlatformStatus.kt` - Individual platform status

### **Data/Simulation (5 files)**
- `DemoDataService.kt` - Central data provider
- `SimulationEngine.kt` - Core simulation loop
- `LiveStreamSimulator.kt` - Realistic fake stream data
- `SystemMetricsSimulator.kt` - CPU/RAM/Temp simulation
- `AudioLevelSimulator.kt` - Audio level animation

### **Main Activity & Entry Point (1 file)**
- `MainActivity.kt` - App entry point with Compose setup

### **Resources (5 files)**
- `colors.xml` - Color definitions
- `dimens.xml` - Dimension constants
- `ic_launcher_background.xml`
- `ic_launcher.xml`
- `ic_launcher_round.xml`

---

## Summary Statistics

- **Total Files to Create**: 51
- **Kotlin Source Files**: 36
- **XML Resource Files**: 8
- **Configuration Files**: 3
- **Documentation Files**: 2 (README, PROJECT_STRUCTURE)

## UI Architecture

- **Theme**: Dark Futuristic with Blue Neon accents
- **Layout**: Compose-based (no XML layouts)
- **Navigation**: Bottom tab navigation + nested screen graphs
- **Optimization**: Tablet-first (7"), responsive for phones
- **Orientation**: Landscape & Portrait support

Ready to generate all files?
