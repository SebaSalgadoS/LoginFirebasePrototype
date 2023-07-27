package com.sebasalgado.loginfirebaseprototype.data.database

import com.google.firebase.database.FirebaseDatabase
import com.sebasalgado.loginfirebaseprototype.data.model.User

class LoginDataBase {

    private fun dataBase() {
        val dataBase = FirebaseDatabase.getInstance()
        val reference = dataBase.getReference("user")
        val key = reference.push().key
        reference.child(key.toString())
            .setValue(User(key.toString(), "Sebastian", "seba123@123.com", "pass1233223"))
    }

}