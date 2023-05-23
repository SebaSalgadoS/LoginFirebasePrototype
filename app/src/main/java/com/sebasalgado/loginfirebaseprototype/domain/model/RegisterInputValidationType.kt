package com.sebasalgado.loginfirebaseprototype.domain.model

enum class RegisterInputValidationType {
    EmptyField,
    NoEmail,
    PasswordsDoNoMatch,
    PasswordTooShort,
    PasswordUpperCaseMissing,
    PasswordNumberMissing,
    PasswordSpecialCharMissing,
    Valid
}