package com.sebasalgado.loginfirebaseprototype.utils

import com.sebasalgado.loginfirebaseprototype.utils.extentions.isEmail
import org.junit.Assert.assertEquals
import org.junit.Test

class ValidatorTest {

    @Test
    fun validateEmailTextInputReturnFalse() {
        val result = "esuncorreogmail.com".isEmail()
        assertEquals(result, false)
    }

    @Test
    fun validateEmailTextInputReturnTrue() {
        val result = "esuncorreo@gmail.com".isEmail()
        assertEquals(result, true)
    }
}