package com.ksi.examplecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ksi.examplecompose.ui.theme.ExampleComposeTheme
import com.ksi.examplecompose.ui.theme.defaultPadding
import java.util.Collections.list
/*
good ux mean
1- user needs
2- business goals
to solve problem need answer 5w
1-who [young user-old users]
2- what[what is the problem]
3 when [when problem happen]
4 why [reason of problem ]
5 where[app or web]
=======================
what is not ux
1-not interface design
2- not astep in aprocess
3- not about technology (pull-push door)
4- npt about usability
5- not juste about user (conside cost for bussinees or any bussiness goal)
============
ux attributes
1-useful
purpose for target user
2- usable
easy to use easy
3-findable
4- credible
make user trust app like buy online show why paied total
5- accessible
lamguage
6- desirable
color hormeny- icons
7- valuable
deliver value to business and user like whatapp you can send any msg for free
=============
elements
1- strategy
what are the business objective? what do our user need?
what is the user- what is business goal
noon
age from 20 to 25
for user need buy online
for business install 10000
2- scope
tranform strategy into requirments what features will the site include?
feature
 profile-register-product categry-payment
3- structure
give shape to scope how will pieces of the site fir together and behave
how many pages in web  what is action -flow of user
4- skeleton
make structure concrete what components will enable people to use site?
pages details login contain enail password
5- surface
begin everthing together visually what will the finished product will look like
colors icon
===================
strategy (bussiness goal -user needs ) we defined this by search by steps
1- stack holders interviews [people in company  will the app useful for  them]
2-competitor reviews
3-user research /interviews
4- existing product audit
====================
stackholder interview with ceo cto with marketing team
or any one help to know goal of bussiness
q
1- what is the goal of product
booking.com objective استكشف العالم
facebook connect people
2-customer or users/segment users
3-what is the value diffretn between another product
4- why people not use your project
5- success metrics
example how many user used specific feature
==========
competitors review
1- customer acquistion >اكتر حاجه بيحبها الزبون فى منتج المنافس
2-لو فيه منافس قوى وفيه منافس جديد تفوق عليه ايه اللى خلاه يتوفوق عليه
3-لو فيه منافس كان موجود  واختفى ليه اختفى
4-core feature متالش عن المنافسين
5- marketing strategy كوبون وهكذا
===============================
user interview
user needs
user segmentation[gender-age-]
q
persona شخصيه خياليه من اسالت المستخدم
come from user q

============================================
scope
--------------------------------------
1-function specification
eaxample noo
 1- search page -order page - login-register ->from requirement
2-content ->imsge-text-audio
we need make sure
requirment clear
user can track package -> not clear
what is the limitation for tech

============================================
structure
==========================================
1- interaction design

محادثة بين المستخدم والنظام
نستخدم عناصر معرفه من مواقع اخرى ذى شكل اللينك
يميز الفورم او الزرار
عمل كليك لازم نرد بحاجه عمل فيد باك عشان المستخدم يعرف
ولو فيه خطا يعرف ان فيه خظ

2- information architecture النقسيمات ->home -meida-product
على حسب الأهميه هرتب الصفحات والمحتوى
مثال جايزة الاسكر فيه اسم the beast-oscare- actorr name-
order will be
1- the best
2- actor name
3- oscar


-------
3- flexible to be scalable
==========================
skeleton
==============
is more detail speak about elements -navigation
1- interface design
  a-inputs
  b-navigation
  c-information
2- navigation design
ask this question at any page
Where are you?
How Did you arrive here?
what can you do here?
where can you go from here?
navigation best practices
give users visible indicator of wich screen they are looking at
use filter to narrow large sets of information
set the correct expectation
=============================
The surface element
=============================
1- visual design elements
need know
1- layout
organized elements like grid
2-tepgraphy
fonts-style max use 2 fonts and prefer google fonts
3-colors
minimize color
4-imagery
quilty image is important
5- seqencing
order elements
2-visual design principles
--------------
1- Balance
every item shoulde have weiht in screen
حتى لا يكون هناك اماكان مزدحمه فى التصميم
2-emphais
العناصر الاكثر اهميه ابرزها عن طريق واحده من
  a- color
  b-placement
 c-isolation like google put only search field
3-white space
spce between elements
4- alignment
5-consistency
 ask q
1-all screen same style for example header same in all page
6-follow the eye
z pattern
like fb  look from left to right
f patern
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleComposeTheme {
                // A surface container using the 'background' color from the theme
                //hoistable state remove dublicate state

                Surface(color = MaterialTheme.colors.background) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    //remeberSeverabale save value even configer of app changed
    var onBoard by remember {
        mutableStateOf(true)
    }
    if(onBoard){
        OnboardingScreen({onBoard=false})
    }else{
        Greetings()
    }

}
@Composable
fun Greetings(names: List<String> =List(1000){"$it"}){
    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.padding(defaultPadding)) {
            LazyColumn {
                items(names){name->
                    Greeting(name = name)
                    
            }
              
            }
        }
    }
}
@Composable
fun Greeting(name:String){
    //remember to save last value when recompose happened
    //mutablestate will recompose element depond on this value
    //by to delegate
    var expand by remember {  mutableStateOf(false)}


   val expandValue=if(expand) 34.dp else 0.dp
    Surface(color = MaterialTheme.colors.primary,modifier = Modifier.padding(horizontal = 8.dp ,vertical = 8.dp)) {
      Row(modifier = Modifier
          .padding(defaultPadding)) {
          Column(modifier = Modifier
              .weight(0.1f)
              .padding(bottom = expandValue)) {
              Text(text = "Hello ")
              Text(text = "$name!")
          }
          OutlinedButton(onClick = { expand=!expand }) {
              Text( if (expand) stringResource(R.string.cc) else "Show More")
          }
      }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExampleComposeTheme {
       // MyApp()
        OnboardingScreen({})
    }
}
@Composable
fun OnboardingScreen(onContenueClicked:()->Unit) {
    // TODO: This state should be hoisted
   // var shouldShowOnboarding by remember { mutableStateOf(true) }

    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text("Welcome to the Basics Codelab!")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContenueClicked
            ) {
                Text("Continue")
            }
        }
    }
}
@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    ExampleComposeTheme {
        OnboardingScreen({})
    }
}