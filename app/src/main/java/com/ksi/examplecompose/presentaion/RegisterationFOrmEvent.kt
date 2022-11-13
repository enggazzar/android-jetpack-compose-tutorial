package com.ksi.examplecompose.presentaion

sealed class RegisterationFOrmEvent {
    data class EmailChanged(val email: String) : RegisterationFOrmEvent()
    data class PasswordChanged(val password: String) : RegisterationFOrmEvent()
    data class RepeatedPasswordChanged(val repeatedPassword: String) : RegisterationFOrmEvent()
    data class AcceptTerms(val accept: Boolean) : RegisterationFOrmEvent()
    object  Submit:RegisterationFOrmEvent()
}
