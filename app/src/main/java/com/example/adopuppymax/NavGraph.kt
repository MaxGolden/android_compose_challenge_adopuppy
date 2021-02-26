package com.example.adopuppymax

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.adopuppymax.MainDestinations.PUPPY_DETAIL_ID_KEY
import com.example.adopuppymax.ui.main.MainPuppyDemo
import com.example.adopuppymax.ui.main.puppies
import com.example.adopuppymax.ui.puppy.PuppyDetails
import com.example.adopuppymax.ui.theme.PuppyMaxTheme


/**
 * Destinations used in the ([PuppyApp]).
 */
object MainDestinations {
    const val PUPPY_DEMO_ROUTE = "puppy_demo"
    const val PUPPY_DETAIL_ROUTE = "puppy"
    const val PUPPY_DETAIL_ID_KEY = "puppyId"
}

@Composable
fun NavGraph(startDestination: String = MainDestinations.PUPPY_DEMO_ROUTE) {
    val navController = rememberNavController()
    val actions = remember(navController) { MainActions(navController) }
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.PUPPY_DEMO_ROUTE) {
            PuppyMaxTheme {
                Scaffold(
                    backgroundColor = MaterialTheme.colors.primarySurface
                ) {
                    val modifier = Modifier.padding(it)
                    MainPuppyDemo(puppyList = puppies, selectPuppy = actions.selectCourse, modifier)
                }
            }
        }
        composable(
            "${MainDestinations.PUPPY_DETAIL_ROUTE}/{$PUPPY_DETAIL_ID_KEY}",
            arguments = listOf(navArgument(PUPPY_DETAIL_ID_KEY) { type = NavType.LongType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            PuppyDetails(
                puppyId = arguments.getLong(PUPPY_DETAIL_ID_KEY),
                selectPuppy = actions.selectCourse,
                upPress = actions.upPress
            )
        }
    }
}

/**
 * Models the navigation actions in the app.
 */
class MainActions(navController: NavHostController) {
    val selectCourse: (Long) -> Unit = { courseId: Long ->
        navController.navigate("${MainDestinations.PUPPY_DETAIL_ROUTE}/$courseId")
    }
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}
