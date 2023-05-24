package com.sebasalgado.loginfirebaseprototype.domain.use_case

import com.sebasalgado.loginfirebaseprototype.domain.model.LogingInputValidationType
import org.junit.Test
import org.junit.Assert.*

class ValidateLoginInputTest {

    private val validateLoginInputUseCase = ValidateLoginInputUseCase()

    @Test
    fun testEmptyFieldReturnsValidationTypeEmptyField() {
        val result = validateLoginInputUseCase("", "password")
        assertEquals(result, LogingInputValidationType.EmplyField)
    }

    @Test
    fun testEmptyPasswordFieldReturnsValidationTypeEmptyField() {
        val result = validateLoginInputUseCase("pepito@gmail.com", "")
        assertEquals(result, LogingInputValidationType.EmplyField)
    }

    @Test
    fun testNoEmailFieldReturnsTrueValidationTypeNoEmailField() {
        val result = validateLoginInputUseCase("pepitogmail.com", "password")
        assertEquals(result, LogingInputValidationType.NoEmail)
    }

    @Test
    fun testValidFieldReturnsValidationTypeField() {
        val result = validateLoginInputUseCase("pepito@gmail.com", "password")
        assertEquals(result, LogingInputValidationType.Valid)
    }

}