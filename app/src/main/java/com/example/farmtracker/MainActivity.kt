package com.example.farmtracker

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.auth.ui.signUp.compact.SignUpCompact
import com.example.auth.ui.signUp.large.SignUpLarge
import com.example.auth.ui.signUp.medium.SignUpMedium
import com.example.farmtracker.ui.theme.AppTheme
import com.example.onboarding.ui.medium.OnBoardingMedium
import com.example.onboarding.ui.small.OnBoardingSmall


class MainActivity : ComponentActivity() {
    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val w = window
        w.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val windowInfo = rememberWindowInfo()
                    val startScreen: String = if (windowInfo.screenWidthInfo is windowInfo.windowType.Compact || windowInfo.screenWidthInfo is windowInfo.windowType.Medium){
                        "OnBoarding"
                    }else{
                        "SignUp"
                    }

                    if (windowInfo.screenWidthInfo is windowInfo.windowType.Compact || windowInfo.screenWidthInfo is windowInfo.windowType.Medium){
                        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                    }

                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = startScreen){
                        composable("OnBoarding"){
                            if (windowInfo.screenWidthInfo is windowInfo.windowType.Compact){
                                OnBoardingSmall().OnBoardingScreen(navController = navController)
                            }else{
                                OnBoardingMedium().OnBoardingScreen(navController = navController)
                            }
                        }

                        composable("SignUp"){
                            when (windowInfo.screenWidthInfo) {
                                is windowInfo.windowType.Compact -> {
                                    SignUpCompact().SignUpCompactScreen()
                                }

                                is windowInfo.windowType.Medium -> {
                                    SignUpMedium().SignUpMediumScreen()
                                }

                                else -> {
                                    SignUpLarge().SignUpLargeScreen()
                                }
                            }
                        }

                    }


                }
            }
        }
    }
}
