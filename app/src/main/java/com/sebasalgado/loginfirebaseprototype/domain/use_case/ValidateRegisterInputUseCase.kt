package com.sebasalgado.loginfirebaseprototype.domain.use_case

import com.sebasalgado.loginfirebaseprototype.domain.model.RegisterInputValidationType
import com.sebasalgado.loginfirebaseprototype.utils.constants.MIN_PASS_LENGTH
import com.sebasalgado.loginfirebaseprototype.utils.extentions.*

class ValidateRegisterInputUseCase {

    operator fun invoke(
        email: String,
        password: String,
        passwordRepeated: String
    ): RegisterInputValidationType {
        if (email.isEmpty() || password.isEmpty() || passwordRepeated.isEmpty()) {
            return RegisterInputValidationType.EmptyField
        }
        if (email.isEmail()) {
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
        if (!password.containsUpperCase()) {
            return RegisterInputValidationType.PasswordUpperCaseMissing
        }
        if (!password.containsSpecialChar()) {
            return RegisterInputValidationType.PasswordSpecialCharMissing
        }
        return RegisterInputValidationType.Valid

    }
}