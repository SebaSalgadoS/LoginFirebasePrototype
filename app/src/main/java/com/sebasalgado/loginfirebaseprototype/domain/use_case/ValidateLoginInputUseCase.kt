package com.sebasalgado.loginfirebaseprototype.domain.use_case

import com.sebasalgado.loginfirebaseprototype.domain.model.LogingInputValidationType
import com.sebasalgado.loginfirebaseprototype.utils.extentions.isEmail

class ValidateLoginInputUseCase {

    //TODO: agregar caso de que tenga mas de 6 cartacteres

    operator fun invoke(email: String, password: String): LogingInputValidationType {
        if (email.isEmpty() || password.isEmpty()) {
            return LogingInputValidationType.EmplyField
        }
        if (email.isEmail()) {
            return LogingInputValidationType.NoEmail
        }
        return LogingInputValidationType.Valid
    }
}