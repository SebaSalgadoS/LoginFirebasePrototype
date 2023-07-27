package com.sebasalgado.loginfirebaseprototype.ui.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.sebasalgado.loginfirebaseprototype.domain.model.LogingInputValidationType
import com.sebasalgado.loginfirebaseprototype.domain.use_case.ValidateLoginInputUseCase

class FragmentLoginViewModel: ViewModel() {

    val validator = ValidateLoginInputUseCase()

    // todo: esto deberia ir en el registro
    fun saveUser(email: String, password: String){
        val authInstance = Firebase.auth
        if(validator.invoke(email, password) == LogingInputValidationType.Valid){
            val taskCreateUser = authInstance.createUserWithEmailAndPassword(email, password).addOnCompleteListener {task ->
                if(task.isSuccessful){
                    Log.e("TASK LOGIN VIEW MODEL", "TASK SUCCESS!")
                }else{
                    task.exception
                    Log.e("TASK LOGIN VIEW MODEL", task.toString())
                }
            }
        }
    }


}