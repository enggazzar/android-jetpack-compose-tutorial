package com.ksi.examplecompose.presentaion

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ksi.examplecompose.ui.theme.ExampleComposeTheme
import kotlinx.coroutines.flow.collect

//pagination
//theme
//multi screen
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleComposeTheme {
                MyApp()
            }
        }
    }

    @Composable
    fun MyApp() {
        val viewModel = viewModel<MainViewModel>()
        val stat = viewModel.state
        val context = LocalContext.current
        LaunchedEffect(key1 = context) {
            viewModel.validationEvent.collect { event ->
                when (event) {
                    is ValidateEvent.Success -> {
                        Log.e("success", "success")
                    }
                }
            }
        }
        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = stat.email,
                onValueChange = {
                    viewModel.onEvent(RegisterationFOrmEvent.EmailChanged(it))
                },
                isError = stat.emailError != null,
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(text = "Email")
                },
                keyboardOptions = (KeyboardOptions(keyboardType = KeyboardType.Email))

            )
            if (stat.emailError != null) {
                Text(text = stat.emailError, color = Color.Red)
            }
            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = stat.password,
                onValueChange = {
                    viewModel.onEvent(RegisterationFOrmEvent.PasswordChanged(it))
                },
                isError = stat.passwordError != null,
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(text = "password")
                },
                keyboardOptions = (KeyboardOptions(keyboardType = KeyboardType.Password)),
                visualTransformation = PasswordVisualTransformation()

            )
            if (stat.passwordError != null) {
                Text(text = stat.passwordError, color = Color.Red)
            }
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = stat.repeatPassword,
                onValueChange = {
                    viewModel.onEvent(RegisterationFOrmEvent.RepeatedPasswordChanged(it))
                },
                isError = stat.repeatpasswordError != null,
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(text = "repeat password")
                },
                keyboardOptions = (KeyboardOptions(keyboardType = KeyboardType.Password)),
                visualTransformation = PasswordVisualTransformation()

            )
            if (stat.repeatpasswordError != null) {
                Text(text = stat.repeatpasswordError, color = Color.Red)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Checkbox(checked = stat.acceptTerms,
                    onCheckedChange = {
                        viewModel.onEvent( RegisterationFOrmEvent.AcceptTerms(it))
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Accept terms")
            }
            if (stat.termsError != null) {
                Text(text = stat.termsError, color = Color.Red)
            }
            Button(onClick = { viewModel.onEvent(RegisterationFOrmEvent.Submit) }
            ,modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "Submet")
            }
            

        }
    }

}





