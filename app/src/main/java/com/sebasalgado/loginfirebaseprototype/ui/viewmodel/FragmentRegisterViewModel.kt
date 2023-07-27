package com.sebasalgado.loginfirebaseprototype.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.sebasalgado.loginfirebaseprototype.data.model.User
import com.sebasalgado.loginfirebaseprototype.domain.model.RegisterInputValidationType
import com.sebasalgado.loginfirebaseprototype.domain.use_case.CreateUserUseCase
import com.sebasalgado.loginfirebaseprototype.domain.use_case.ValidateRegisterInputUseCase

class FragmentRegisterViewModel : ViewModel() {

    val validatorRegister = ValidateRegisterInputUseCase()
    val registerUser = CreateUserUseCase()

    fun registerNewUser(user: User, repitePassword: String) {
        val authInstance = Firebase.auth
        if (validatorRegister.invoke(
                user.email,
                user.password,
                repitePassword
            ) == RegisterInputValidationType.Valid
        ) {
            //TODO: crear funcion en el if que devuelva true y guarde el usuario
           registerUser.saveUser { newUser, exception ->
               if (newUser == true){
                   saveUserInDataBase(user)
               }else{
                   //agregar toast , log o un string
                   throw error("Error Saving User")
               }
           }
        }
    }

    private fun saveUserInDataBase(user: User) {
        val databaseInstance = Firebase.database
        val databaseReference = databaseInstance.getReference("user")
        val key = databaseReference.push().key
        databaseReference.child(key.toString()).setValue(
            User(
                id = key.toString(),
                username = user.username,
                email = user.email,
                password = user.password
            )
        )
    }
}