package com.ksi.examplecompose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ContentAlpha.medium
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ksi.examplecompose.R
import com.ksi.examplecompose.ui.theme.LightPrimaryColor
import com.ksi.examplecompose.ui.theme.LightTextColor
import com.ksi.examplecompose.ui.theme.SecondaryColor
import com.ksi.examplecompose.ui.theme.Shapes

@Preview(showBackground = true)
@Composable
fun SettingScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        HeaderUi()
        profileCardUi()
        generalOptionUi()
        SuppotOptionUi()
    }
}

@Composable
fun HeaderUi() {
    Text(
        text = "Setting", modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp),
        textAlign = TextAlign.Center,
        color = SecondaryColor, fontSize = 16.sp,
        fontWeight = FontWeight.ExtraBold

    )
}

@Composable
fun SuppotOptionUi() {
    Text(
        text = "Support",
        textAlign = TextAlign.Center,
        color = SecondaryColor, fontSize = 16.sp,
        fontWeight = FontWeight.ExtraBold,
        modifier = Modifier.padding(top = 20.dp, start = 10.dp)

    )
    ItemSupport()
}

@Composable

fun generalOptionUi() {
    Text(
        text = "General",
        textAlign = TextAlign.Center,
        color = SecondaryColor, fontSize = 16.sp,
        fontWeight = FontWeight.ExtraBold,
        modifier = Modifier.padding(top = 20.dp, start = 10.dp)

    )
    ItemGeneral()
    ItemGeneral()
  //  ItemGeneral()

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemGeneral() {
    Card(
        backgroundColor = Color.White,
        modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth(),
        elevation = 0.dp,
        onClick = {}
    ) {
        Row(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Row() {


                    Box(
                        modifier = Modifier
                            .size(34.dp)
                            .clip(shape = Shapes.medium)
                            .background(LightPrimaryColor)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_rounded_notification),
                            contentDescription = "",
                            tint = Color.Unspecified,
                            modifier = Modifier.padding(8.dp)
                        )
                    }

                }

                Column(Modifier.padding(start = 10.dp)) {
                    Text(
                        text = "mainText",
                        color = SecondaryColor,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                    )

                    Text(
                        text = "subText",
                        //fontFamily = Poppins,
                        color = Color.Gray,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        // modifier = Modifier.offset(y = (-4).dp)
                    )
                }
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_right_arrow),
                contentDescription = "",
                modifier = Modifier.size(16.dp)
            )
        }
    }
}
@Composable
fun ItemSupport() {
    Card(

        backgroundColor = MaterialTheme.colors.surface,
        shape = Shapes.large,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp,), elevation = 0.dp
    )
    {
        Row(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Row() {


                    Box(
                        modifier = Modifier
                            .size(34.dp)
                            .clip(shape = Shapes.medium)
                            .background(LightPrimaryColor)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_rounded_notification),
                            contentDescription = "",
                            tint = Color.Unspecified,
                            modifier = Modifier.padding(8.dp)
                        )
                    }

                }

                Column(Modifier.padding(start = 10.dp)) {
                    Text(
                        text = "mainText",
                        color = SecondaryColor,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                    )

                }
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_right_arrow),
                contentDescription = "",
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
fun profileCardUi() {
    Card(
        backgroundColor = MaterialTheme.colors.surface,
        shape = Shapes.large,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), elevation = 0.dp
    )
    {
        Row(modifier = Modifier.padding(15.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Column() {
                Text(
                    text = "Check Your Profile",
                    textAlign = TextAlign.Center,
                    color = SecondaryColor, fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold

                )
                Text(
                    text = "ui.stach.yt@gmail.com",
                    textAlign = TextAlign.Center,
                    color = LightTextColor, fontSize = 12.sp,
                    fontWeight = FontWeight.ExtraBold

                )
                Button(
                    onClick = { },
                    modifier = Modifier.padding(top = 10.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                    shape = Shapes.medium


                ) {
                    Text(
                        text = "view",
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.ExtraBold

                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.ic_profile_card_image),
                alignment = Alignment.CenterEnd,
                modifier = Modifier.height(100.dp),
                contentDescription = ""
            )
        }
    }
}
