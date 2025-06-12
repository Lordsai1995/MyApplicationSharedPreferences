package com.example.myapplicationsharedpreferences
import android.app.Activity
import android.content.SharedPreferences
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun WelcomeScreen(sharedPref: SharedPreferences) {
    val username = sharedPref.getString("username", "Guest") ?: "Guest"

    val context = LocalContext.current
    val activity = context as? Activity

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Welcome, $username!", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            // Clear saved login and restart app
            sharedPref.edit().clear().apply()
            activity?.recreate()
        }) {
            Text("Logout")
        }
    }
}
