package com.nickdferrara.ui_android_heroapp.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.accompanist.pager.ExperimentalPagerApi
import com.nickdferrara.ui_android_heroapp.presentation.screens.home.HomeScreen
import com.nickdferrara.ui_android_heroapp.presentation.screens.splash.SplashScreen
import com.nickdferrara.ui_android_heroapp.presentation.screens.welcome.WelcomeScreen
import com.nickdferrara.ui_android_heroapp.util.Constants.DETAILS_ARGUMENT_KEY

@ExperimentalPagerApi
@Composable
fun SetupNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen()
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(DETAILS_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {

        }
        composable(route = Screen.Search.route) {

        }
    }
}