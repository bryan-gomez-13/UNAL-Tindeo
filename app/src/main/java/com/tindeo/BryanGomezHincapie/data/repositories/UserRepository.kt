package com.tindeo.BryanGomezHincapie.data.repositories

import android.graphics.Bitmap
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.tasks.await
import java.io.ByteArrayOutputStream
import java.lang.Error

class UserRepository (private val dataSource: FirebaseAuth, private val dataSourceStorage: StorageReference){

    suspend fun loggedIn():FirebaseUser?{
        return dataSource.currentUser
    }

    suspend fun signUp(email: String, name: String, password: String):FirebaseUser?{
            try {
        dataSource.createUserWithEmailAndPassword(email, password).await()
        val user = dataSource.currentUser
        val profileUpdate = userProfileChangeRequest {
            displayName = name
            }
        user!!.updateProfile(profileUpdate).await()
        return user
            } catch (e: FirebaseAuthUserCollisionException) {
        throw Error("Correo electronico en uso")
        }
    }
    suspend fun logIn(email: String, password: String): FirebaseUser? {
        try {
            dataSource.signInWithEmailAndPassword(email, password).await()
            return dataSource.currentUser
        } catch (e: FirebaseAuthInvalidCredentialsException) {
            throw Error("Credenciales invalidas")
        } catch (e: FirebaseAuthInvalidUserException){
            throw Error("Usuario dehabilitado")
        }
    }

    suspend fun logOut(): FirebaseUser?{
        dataSource.signOut()
        return null
    }
    suspend fun uploadImage(bitmap: Bitmap): FirebaseUser? {
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()
        val user = dataSource.currentUser
        val profileRef = dataSourceStorage.child("${user!!.uid}.jpg")
        profileRef.putBytes(data).await()
        var uri = profileRef.downloadUrl.await()
        val profileUpdate = userProfileChangeRequest {
            photoUri = uri
        }
        user!!.updateProfile(profileUpdate)
        return user
    }

}