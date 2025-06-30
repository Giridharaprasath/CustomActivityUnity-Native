package com.melonstudios.customactivityunity

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.melonstudios.customactivityunity.ui.theme.CustomActivityUnityTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CustomActivityUnityTheme {
                val snackBarHostState = remember { SnackbarHostState() }
                val snackBarScope = rememberCoroutineScope()
                Scaffold(content = {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(onClick = {
                            showToastDemo()
                        }) {
                            Text(text = "Show Toast Demo", color = Color.White)
                        }
                        Button(onClick = {
                            alertDialogDemo()
                        }) {
                            Text(text = "Show Alert Dialog Demo", color = Color.White)
                        }
                        Button(onClick = {
                            alertDialogWithCloseButtonDemo()
                        }) {
                            Text(
                                text = "Show Alert Dialog Demo With Close Button",
                                color = Color.White
                            )
                        }
                        Button(onClick = {
                            snackBarDemo(snackBarScope, snackBarHostState)
                        }) {
                            Text(text = "Show Snack Bar Demo", color = Color.White)
                        }
                    }
                }, snackbarHost = { SnackbarHost(hostState = snackBarHostState) })
            }
        }
    }

    fun showToastDemo() {
        Toast.makeText(this, "Sample Toast Demo", Toast.LENGTH_SHORT).show()
    }

    fun alertDialogDemo() {
        AlertDialog.Builder(this).setTitle("Sample Alert Dialog")
            .setMessage("Sample Alert Dialog Demo Message").show()
    }

    fun alertDialogWithCloseButtonDemo() {
        AlertDialog.Builder(this).setTitle("Sample Alert Dialog")
            .setMessage("Sample Alert Dialog Demo With Close Button Message").setCancelable(false)
            .setNegativeButton("Close") { dialog, which -> showToastDemo() }.show()
    }

    fun snackBarDemo(snackBarScope: CoroutineScope, snackBarHostState: SnackbarHostState) {
        snackBarScope.launch {
            snackBarHostState.showSnackbar(
                message = "Sample Snack Bar Demo",
                duration = SnackbarDuration.Short
            )
        }
    }
}
