package com.ksi.examplecompose.presentaion

data class RegisterationFormState(
    val email:String="",
    val emailError:String?=null,
    val password:String="",
    val passwordError:String?=null,
    val repeatPassword:String="",
    val repeatpasswordError:String?=null,
    val acceptTerms:Boolean=false,
    val termsError:String?=null
)
