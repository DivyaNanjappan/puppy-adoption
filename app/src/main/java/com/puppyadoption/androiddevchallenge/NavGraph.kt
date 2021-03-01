package com.puppyadoption.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.puppyadoption.androiddevchallenge.MainDestinations.PUPPY_ID_KEY
import com.puppyadoption.androiddevchallenge.ui.Puppies
import com.puppyadoption.androiddevchallenge.ui.PuppyDetail

object MainDestinations {
    const val LIST_PUPPIES = "list_puppies"
    const val PUPPY_DETAIL = "puppy_detail"
    const val PUPPY_ID_KEY = "puppyId"
}

@Composable
fun NavGraph(startDestination: String = MainDestinations.LIST_PUPPIES) {
    val navController = rememberNavController()

    val actions = remember(navController) { MainActions(navController) }
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.LIST_PUPPIES) {
            Puppies(selectPuppy = actions.selectPuppy)
        }
        composable(
            "${MainDestinations.PUPPY_DETAIL}/{$PUPPY_ID_KEY}",
            arguments = listOf(navArgument(PUPPY_ID_KEY) { type = NavType.IntType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            PuppyDetail(
                puppyId = arguments.getInt(PUPPY_ID_KEY),
                upPress = actions.upPress
            )
        }
    }
}


/**
 * Models the navigation actions in the app.
 */
class MainActions(navController: NavHostController) {
    val selectPuppy: (Int) -> Unit = { puppyId: Int ->
        navController.navigate("${MainDestinations.PUPPY_DETAIL}/$puppyId")
    }

    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}