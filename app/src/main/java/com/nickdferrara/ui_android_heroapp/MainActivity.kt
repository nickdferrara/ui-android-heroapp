package com.nickdferrara.ui_android_heroapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.nickdferrara.ui_android_heroapp.navigation.SetupNavigationGraph
import com.nickdferrara.ui_android_heroapp.ui.theme.UiandroidheroappTheme
import dagger.hilt.android.AndroidEntryPoint
@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UiandroidheroappTheme {
                navController = rememberNavController()
                SetupNavigationGraph(navController = navController)
            }
        }
    }
}