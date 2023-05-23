package com.sebasalgado.loginfirebaseprototype.utils.extentions

fun String.containsNumbers(): Boolean{
    val regex = Regex(".*\\d+.*")
    return regex.matches(this)
}

fun String.constainsUpperCase(): Boolean{
    val regex = Regex(".*[A-Z]+.*")
    return regex.matches(this)
}

fun String.constainsSpecialChar(): Boolean{
    val regex = Regex(".*[^A-Za-z\\d]+.*")
    return regex.matches(this)
}