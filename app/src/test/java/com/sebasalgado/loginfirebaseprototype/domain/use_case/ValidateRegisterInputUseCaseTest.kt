package com.sebasalgado.loginfirebaseprototype.domain.use_case

import com.sebasalgado.loginfirebaseprototype.domain.model.RegisterInputValidationType
import org.junit.Assert.assertEquals
import org.junit.Test

class ValidateRegisterInputUseCaseTest {

    private val validateRegisterInputUseCase = ValidateRegisterInputUseCase()

    @Test
    fun testEmptyFieldReturnsValidationTypeEmptyField() {
        val result = validateRegisterInputUseCase("", "", "")
        assertEquals(result, RegisterInputValidationType.EmptyField)
    }

    @Test
    fun testEmptyFieldEmailReturnsValidationTypeEmptyField() {
        val result = validateRegisterInputUseCase("", "password", "password")
        assertEquals(result, RegisterInputValidationType.EmptyField)
    }

    @Test
    fun testEmptyFieldPasswordReturnsValidationTypeEmptyField() {
        val result = validateRegisterInputUseCase("pepito@gmail.com", "", "password")
        assertEquals(result, RegisterInputValidationType.EmptyField)
    }

    @Test
    fun testEmptyFieldPasswordRepeatReturnsValidationTypeEmptyField() {
        val result = validateRegisterInputUseCase("pepito@gmail.com", "password", "")
        assertEquals(result, RegisterInputValidationType.EmptyField)
    }

    @Test
    fun testPasswordsNotMatchReturnsValidationType() {
        val result =
            validateRegisterInputUseCase("pepito@gmail.com", "password123@", "password321@")
        assertEquals(result, RegisterInputValidationType.PasswordsDoNoMatch)
    }

    @Test
    fun testNoUpperCasePasswordReturnsValidationType() {
        val result =
            validateRegisterInputUseCase("pepito@gmail.com", "password123@", "password123@")
        assertEquals(result, RegisterInputValidationType.PasswordUpperCaseMissing)
    }

    @Test
    fun testNoNumberPasswordReturnsValidationType() {
        val result = validateRegisterInputUseCase("pepito@gmail.com", "password@", "password@")
        assertEquals(result, RegisterInputValidationType.PasswordNumberMissing)
    }

    @Test
    fun testNoSpecialCharPasswordReturnsValidationType() {
        val result =
            validateRegisterInputUseCase("pepito@gmail.com", "Password1234", "Password1234")
        assertEquals(result, RegisterInputValidationType.PasswordSpecialCharMissing)
    }

    @Test
    fun testValidInputRegisterReturnsValidationType() {
        val result =
            validateRegisterInputUseCase("pepito@gmail.com", "P@ssword1234", "P@ssword1234")
        assertEquals(result, RegisterInputValidationType.Valid)
    }

}