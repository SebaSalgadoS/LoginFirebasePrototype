package com.sebasalgado.loginfirebaseprototype.domain.use_case

import com.sebasalgado.loginfirebaseprototype.domain.model.RegisterInputValidationType
import com.sebasalgado.loginfirebaseprototype.utils.constants.EMAIL_CHARATER
import com.sebasalgado.loginfirebaseprototype.utils.constants.MIN_PASS_LENGTH
import com.sebasalgado.loginfirebaseprototype.utils.extentions.constainsSpecialChar
import com.sebasalgado.loginfirebaseprototype.utils.extentions.constainsUpperCase
import com.sebasalgado.loginfirebaseprototype.utils.extentions.containsNumbers

class ValidateRegisterInputUseCase {

    operator fun invoke(
        email: String,
        password: String,
        passwordRepeated: String
    ): RegisterInputValidationType {
        if (email.isEmpty() || password.isEmpty() || passwordRepeated.isEmpty()) {
            return RegisterInputValidationType.EmptyField
        }
        if (EMAIL_CHARATER !in email) {
            return RegisterInputValidationType.NoEmail
        }
        if (password != passwordRepeated) {
            return RegisterInputValidationType.PasswordsDoNoMatch
        }
        if (password.count() < MIN_PASS_LENGTH) {
            return RegisterInputValidationType.PasswordTooShort
        }
        if (!password.containsNumbers()) {
            return RegisterInputValidationType.PasswordNumberMissing
        }
        if (!password.constainsUpperCase()) {
            return RegisterInputValidationType.PasswordUpperCaseMissing
        }
        if (!password.constainsSpecialChar()) {
            return RegisterInputValidationType.PasswordSpecialCharMissing
        }
        return RegisterInputValidationType.Valid

    }
}