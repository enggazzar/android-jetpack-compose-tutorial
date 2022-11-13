package com.ksi.examplecompose.presentaion

import android.os.AsyncTask.execute
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.constraintlayout.motion.widget.TransitionBuilder.validate
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ksi.examplecompose.domain.use_case.Validate_Accept_Terms
import com.ksi.examplecompose.domain.use_case.Validate_Email
import com.ksi.examplecompose.domain.use_case.Validate_Password
import com.ksi.examplecompose.domain.use_case.Validate_Repeat_Password
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

//maintain state map use case to compose
class MainViewModel : ViewModel() {
    var state by mutableStateOf(RegisterationFormState())
    private val validationEventChanel = Channel<ValidateEvent>()
    val validationEvent = validationEventChanel.receiveAsFlow()
    fun onEvent(event: RegisterationFOrmEvent) {
        when (event) {
            is RegisterationFOrmEvent.EmailChanged -> {
                //copy tell not change all state
                state = state.copy(email = event.email)

            }
            is RegisterationFOrmEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }
            is RegisterationFOrmEvent.RepeatedPasswordChanged -> {
                state = state.copy(repeatPassword = event.repeatedPassword)
            }
            is RegisterationFOrmEvent.AcceptTerms -> {
                state = state.copy(acceptTerms = event.accept)
            }
            is RegisterationFOrmEvent.Submit -> {
                submetData()
            }
        }

    }

    private fun submetData() {
        val emailResult = Validate_Email().execute(state.email)
        val passwordResult = Validate_Password().execute(state.password)
        val repeatPasswordResult =
            Validate_Repeat_Password().execute(state.repeatPassword, state.password)
        val acceptTerms = Validate_Accept_Terms().execute(state.acceptTerms)
        val hasError = listOf(
            emailResult,
            passwordResult,
            repeatPasswordResult,
            acceptTerms
        ).any { !it.Successful }
        if (hasError) {
            state = state.copy(
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage,
                repeatpasswordError = repeatPasswordResult.errorMessage,
                acceptTerms = acceptTerms.Successful
            )
            return
        }
        viewModelScope.launch {
            validationEventChanel.send(ValidateEvent.Success)
        }
    }
}

sealed class ValidateEvent {
    object Success : ValidateEvent()
}