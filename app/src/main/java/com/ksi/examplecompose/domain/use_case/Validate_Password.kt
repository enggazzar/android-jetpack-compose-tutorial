package com.ksi.examplecompose.domain.use_case
import android.util.Patterns


//Single resposible
//middle layr between data layer
//use case one function execute this use case
class Validate_Password {
    fun execute(password: String): ValidationResult {
        if (password.length<8) {
            return ValidationResult(false, "The Password Must be more than 8 characters")
        }
       val containLetterAndDigit=password.any {it.isDigit()&&it.isLetter()  }
        if(!containLetterAndDigit){
            return ValidationResult(false, "The Password at least must have one letter and one digit")
        }
        return ValidationResult(true)
    }
}