package com.sebasalgado.loginfirebaseprototype.domain.use_case

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreateUserUseCase {

     fun saveUser(function: (Boolean, java.lang.Exception?) -> Unit){
        CoroutineScope(Dispatchers.IO).launch {
            val authInstance = FirebaseAuth.getInstance()
            val taskCreateUser =
                authInstance.createUserWithEmailAndPassword(
                    "salgadoseba89@gmail.com",
                    "password123"
                )
            //TODO: RESULT
            taskCreateUser.addOnCompleteListener {
                val state = it.isSuccessful
                val exception = it.exception
                function(state,exception)
            }
        }
    }
}