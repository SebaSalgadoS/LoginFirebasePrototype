package com.sebasalgado.loginfirebaseprototype.domain.use_case

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.sebasalgado.loginfirebaseprototype.domain.model.LogingInputValidationType

class LoginUserUseCase {

    //variables que injectar
    private val validationLoginInput = ValidateLoginInputUseCase()
    private val firebaseAuth = FirebaseAuth.getInstance()

    operator fun invoke(email: String, password: String) {
        if (validationLoginInput.invoke(
                email = email,
                password = password
            ) == LogingInputValidationType.Valid
        ) {
            firebaseAuth.signInWithEmailAndPassword(email, password)
        } else {
            Log.e("Error al crear Usuario", "Data: $email $password")
        }
    }
}