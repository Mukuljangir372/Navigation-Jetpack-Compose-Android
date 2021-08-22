package com.mu.jan.jetpack

import androidx.navigation.NavController

object Destinations{
    const val Screen1 = "Screen1"
    const val Screen2 = "Screen2"
    const val Screen3 = "Screen3"
}
class Actions(navController: NavController){
    val openScreen1: () -> Unit = {
        navController.navigate(Destinations.Screen1)
    }
    val openScreen2: (String) -> Unit = { userId ->
        navController.navigate(route = "${Destinations.Screen2}/$userId")
    }
    val openScreen3: () -> Unit = {
        navController.navigate(Destinations.Screen3)
    }
    /**
     * WARNING
     * DON'T USER BELOW FUNCTION TO NAVIGATION UP,
     * INSTEAD OF USING IT, POP BACK STACK BY NAME
     */
//    val navigateUp: () -> Unit = {
//        navController.popBackStack()
//    }
    val popScreen2: () -> Unit = {
        navController.popBackStack(route = "${Destinations.Screen2}/{userId}",inclusive = false)
    }
    val popScreen3: () -> Unit = {
        navController.popBackStack(route = Destinations.Screen3,inclusive = true)
    }

}
