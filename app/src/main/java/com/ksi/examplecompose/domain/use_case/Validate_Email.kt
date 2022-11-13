package com.ksi.examplecompose.domain.use_case
import android.util.Patterns


//Single resposible
//middle layr between data layer
//use case one function execute this use case
class Validate_Email {

    fun execute(email: String): ValidationResult {
        if (email.isBlank()) {
            return ValidationResult(false, "The email Can't be blank")
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                false,
                errorMessage = "That's not a valid email"
            )
        }
        return ValidationResult(true)
    }
}