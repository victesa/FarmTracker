package com.example.auth.ui

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.content.IntentSender
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat.startIntentSenderForResult
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AuthViewModel: ViewModel() {

    val auth: FirebaseAuth = Firebase.auth

    data class AuthModel(
        var btnContinueClickable: Boolean = false,
        var btnSignInColor: String = "",
        var btnSignUpColor: String = "",
        var firstName: String = "",
        var lastName: String = ""
    )

    val _uiState = MutableStateFlow(AuthModel())
    val uiState = _uiState.asStateFlow()

    fun continueBtn(firstName: String, lastName: String){
        _uiState.update {
            it.copy(firstName = firstName,
                    lastName = lastName)
        }
    }

    fun signUpWithEmailAndPassword(context: Context,email: String, password: String){
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun signInWithEmailAndPassword(context: Context, email: String, password: String){
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if(it.isSuccessful){
                Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }




}