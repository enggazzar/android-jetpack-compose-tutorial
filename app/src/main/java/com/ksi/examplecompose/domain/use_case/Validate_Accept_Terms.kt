package com.ksi.examplecompose.domain.use_case
import android.util.Patterns


//Single resposible
//middle layr between data layer
//use case one function execute this use case
class Validate_Accept_Terms {
    fun execute(acceptTerms: Boolean): ValidationResult {
        if (!acceptTerms) {
            return ValidationResult(false, "You must accept terms")
        }

        return ValidationResult(true)
    }
}