package com.sebasalgado.loginfirebaseprototype.utils.extentions

fun String.containsNumbers(): Boolean{
    val regex = Regex(".*\\d+.*")
    return regex.matches(this)
}

fun String.containsUpperCase(): Boolean{
    val regex = Regex(".*[A-Z]+.*")
    return regex.matches(this)
}

fun String.containsSpecialChar(): Boolean{
    val regex = Regex(".*[^A-Za-z\\d]+.*")
    return regex.matches(this)
}