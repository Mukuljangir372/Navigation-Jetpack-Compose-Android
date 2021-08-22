package com.mu.jan.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mu.jan.jetpack.ui.theme.JetpackTheme

/**
 * Why we're using ComponentActivity class here?
 * There is a superior activity class named AppCompatActivity
 * that extends FragmentActivity which extends ComponentActivity
 *
 * For compose only apps, you only need ComponentActivity.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackTheme {
                JetpackApp()
            }
        }
    }

}
