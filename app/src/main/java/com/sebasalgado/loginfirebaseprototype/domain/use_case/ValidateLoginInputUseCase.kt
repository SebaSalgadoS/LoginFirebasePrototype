package com.sebasalgado.loginfirebaseprototype.domain.use_case

import com.sebasalgado.loginfirebaseprototype.domain.model.LogingInputValidationType

class ValidateLoginInputUseCase {

    operator fun invoke(email: String, password: String): LogingInputValidationType {
        if (email.isEmpty() || password.isEmpty()) {
            return LogingInputValidationType.EmplyField
        }
        if ("@" !in email) {
            return LogingInputValidationType.NoEmail
        }
        return LogingInputValidationType.Valid
    }
}