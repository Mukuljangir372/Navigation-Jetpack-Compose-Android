package com.mu.jan.jetpack

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.mu.jan.jetpack.ui.theme.Teal200

@Composable
fun JetpackApp(){
    val navController = rememberNavController()
    val actions = remember(navController){ Actions(navController)}

    NavHost(navController = navController,startDestination = "Screen1"){
        composable(route = "Screen1"
            ){
            Screen1(
                openScreen2 = actions.openScreen2
            )
        }
        composable(route = "Screen2/{userId}",
            arguments = listOf(
                navArgument(name = "userId"){
                    type = NavType.StringType
                    defaultValue = "DefaultValue"
                    nullable = false
                }
            )
            ){

            val userId = it.arguments?.getString("userId")
            requireNotNull(userId)

            Screen2(
                navigateUp = actions.popScreen2,
                openScreen3 = actions.openScreen3,
                userId
            )
        }
        composable(route = "Screen3"){
            Screen3(
                navigateUp = actions.popScreen3
            )
        }
    }
}
@Composable
fun Screen1(
    openScreen2: (String) -> Unit
) {
    Surface(color = Color.Red) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Screen1")
        Button(
            onClick = {
                openScreen2("user1234")
            }
        ) {
            Text("Go")
        }

    }
}
}
@Composable
fun Screen2(
    navigateUp: () -> Unit,
    openScreen3: () -> Unit,
    userId : String
){
    Surface(
        color = Teal200
    ) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text("Second2")
        Text("userId = $userId")
        Button(
            onClick = navigateUp
        ){
            Text("Go Back")
        }
        Button(
            onClick = openScreen3
        ){
            Text("Go Further")
        }
    }
}
}
@Composable
fun Screen3(
    navigateUp: () -> Unit
){
    Surface(
        color = Color.Green
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight()
        ) {
            Text("Second3")
            Button(
                onClick = navigateUp
            ){
                Text("Go Back")
            }
        }
    }
}



