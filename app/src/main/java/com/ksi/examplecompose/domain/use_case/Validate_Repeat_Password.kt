package com.ksi.examplecompose.domain.use_case
import android.util.Patterns


//Single resposible
//middle layr between data layer
//use case one function execute this use case
class Validate_Repeat_Password {
    fun execute(password: String,repeated:String): ValidationResult {
        if (password!=repeated) {
            return ValidationResult(false, "The Password Not Match")
        }

        return ValidationResult(true)
    }
}