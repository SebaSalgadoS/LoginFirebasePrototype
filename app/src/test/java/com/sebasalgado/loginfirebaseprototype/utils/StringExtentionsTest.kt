package com.sebasalgado.loginfirebaseprototype.utils

import com.sebasalgado.loginfirebaseprototype.utils.extentions.containsNumbers
import com.sebasalgado.loginfirebaseprototype.utils.extentions.containsSpecialChar
import com.sebasalgado.loginfirebaseprototype.utils.extentions.containsUpperCase
import org.junit.Assert.assertEquals
import org.junit.Test

class StringExtentionsTest {

    @Test
    fun testStringContainsNoNumberReturnsFalseWhenCheckForIT() {
        val result = "NoNumber".containsNumbers()
        assertEquals(result, false)
    }

    @Test
    fun testStringContainsNumberReturnsTrueWhenCheckForIt() {
        val result = "3Number".containsNumbers()
        assertEquals(result, true)
    }

    @Test
    fun testStringContainsNoSpecialCharacterReturnsFalseWhenCheckForIt() {
        val result = "NoSpecialCharacter".containsSpecialChar()
        assertEquals(result, false)
    }

    @Test
    fun testStringContainsSpecialCharacterReturnsTrueWhenCheckForIt() {
        val result = "HaveSpecialCh@racter".containsSpecialChar()
        assertEquals(result, true)
    }

    @Test
    fun testStringContainsUpperCaseReturnsFalseWhenCheckForIt() {
        val result = "nohaveuppercase".containsUpperCase()
        assertEquals(result, false)
    }

    @Test
    fun testStringContainsUpperCaseReturnsTrueWhenCheckForIt() {
        val result = "HaveUpperCase".containsUpperCase()
        assertEquals(result, true)
    }
}