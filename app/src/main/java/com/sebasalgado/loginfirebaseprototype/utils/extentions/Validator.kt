package com.sebasalgado.loginfirebaseprototype.utils.extentions

import java.util.regex.Pattern

private val EMAIL_ADDRESS = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
)

fun String.isEmail() = EMAIL_ADDRESS.matcher(this).matches()
