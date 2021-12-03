package com.tindeo.BryanGomezHincapie.data.repositories

import com.google.firebase.FirebaseError
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.userProfileChangeRequest
import kotlinx.coroutines.tasks.await


class UserRepository(private val dataSource: FirebaseAuth) {
    suspend fun loggedIn(): FirebaseUser?{
        // null si no hay user,
        return dataSource.currentUser
    }

    suspend fun signUp(email: String, name:String, password:String): FirebaseUser? {
        try {
            // Espera que se cree el usuario.await()
            dataSource.createUserWithEmailAndPassword(email,password).await()
            val user = dataSource.currentUser
            // actualiza el nombre del usuario creado
            val profileUpdate = userProfileChangeRequest {
                displayName = name
            }
            user!!.uid
            // actualizar del usuario creado a firebase
            user!!.updateProfile(profileUpdate).await()
            return user
        }catch (e: FirebaseAuthUserCollisionException){
            throw Error("Correo electronico en uso")
        }
    }

    suspend fun logIn(email:String,password: String): FirebaseUser? {
        try {
            dataSource.signInWithEmailAndPassword(email,password).await()
            return dataSource.currentUser
        }catch(e: FirebaseAuthInvalidCredentialsException){
            throw Error("Credenciales invalidas")
        }catch(e: FirebaseAuthInvalidUserException){
            throw Error("Usuario deshabilitado")
        }
    }

    suspend fun logOut(): FirebaseUser? {
        dataSource.signOut()
        return null
    }

}