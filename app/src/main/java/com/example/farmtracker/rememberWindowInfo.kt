package com.example.farmtracker

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun rememberWindowInfo(): windowInfo{
    val configuration = LocalConfiguration.current

    return windowInfo(
        screenWidthInfo = when{
            configuration.screenWidthDp < 600 -> windowInfo.windowType.Compact
            configuration.screenWidthDp < 840 -> windowInfo.windowType.Medium
            else -> windowInfo.windowType.Large
        },
        screenHeightInfo = when{
            configuration.screenHeightDp < 480 -> windowInfo.windowType.Compact
            configuration.screenHeightDp < 900 -> windowInfo.windowType.Medium
            else -> windowInfo.windowType.Large
        },
        screenHeight = configuration.screenHeightDp.dp,
        screenWidth = configuration.screenWidthDp.dp
    )
}

data class windowInfo(
    val screenWidthInfo: windowType,
    val screenHeightInfo: windowType,
    val screenWidth: Dp,
    val screenHeight: Dp
){
    sealed class windowType{
        object Compact: windowType()
        object Medium: windowType()
        object Large: windowType()
    }
}