package com.ksi.examplecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ksi.examplecompose.commoncompose.InputType
import com.ksi.examplecompose.commoncompose.TextInput
import com.ksi.examplecompose.ui.theme.ExampleComposeTheme
import com.ksi.examplecompose.ui.theme.defaultPadding
import java.util.Collections.list

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleComposeTheme {
                // A surface container using the 'background' color from the theme
                //hoistable state remove dublicate state

                Surface(color = MaterialTheme.colors.background) {
                    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

                        val passwordFocusRequester = FocusRequester()
                        var txt by remember { mutableStateOf("") }

                        TextInput(InputType.Name, keyboardActions = KeyboardActions(onNext = {
                            passwordFocusRequester.requestFocus()
                        }))

                        TextInput(InputType.Password, keyboardActions = KeyboardActions(onDone = {

                        }), focusRequester = passwordFocusRequester)


                        MyEditText(
                            value = txt,
                            label = "name",
                            plachholder = "place holder",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp),
                            onChange = { txt = it })

                        MyEditTextEmail(
                            value = txt,
                            label = "email",
                            plachholder = "place holder",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp),
                            onChange = { txt = it })

                    MyEditTextPassword(
                        value = txt,
                        label = "password",
                        plachholder = "place holder",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        onChange = { txt = it })
                        MyButton(txt = "log In", modifier = Modifier, onClick = {})
                       MyTxt(txt = "My txt", modifier =Modifier)

                }
                }
            }
        }
    }
}

