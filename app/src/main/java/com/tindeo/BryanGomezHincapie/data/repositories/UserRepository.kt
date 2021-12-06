package com.tindeo.BryanGomezHincapie.data.repositories

import android.graphics.Bitmap
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.StorageReference
import com.tindeo.BryanGomezHincapie.data.models.StoreInfo
import com.tindeo.BryanGomezHincapie.utils.Constants
import kotlinx.coroutines.tasks.await
import java.io.ByteArrayOutputStream
import java.lang.Error

class UserRepository(
    private val dataSource: FirebaseAuth,
    private val dataSourceStorage: StorageReference,
    private val dataFireStore: FirebaseFirestore
) {

    suspend fun  loggedIn(): FirebaseUser? {
        return dataSource.currentUser
    }

    suspend fun signUp(email: String, name: String, password: String, apellidos: String, celular:String): FirebaseUser? {
        try {
            dataSource.createUserWithEmailAndPassword(email, password).await()
            val user = dataSource.currentUser
            val profileUpdate = userProfileChangeRequest {
                displayName = name
            }
            user!!.updateProfile(profileUpdate).await()
            dataFireStore.collection(Constants.USERS_COLLECTION).document(user!!.uid).set(
                hashMapOf(  "id" to user.uid,
                            "nombre" to name,
                            "apellidos" to apellidos,
                            "celular" to celular
                    )
            ).await()
            //user.uid --> Unit identificator   Collection firestore
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
        } catch (e: FirebaseAuthInvalidUserException) {
            throw Error("Usuario dehabilitado")
        }
    }

    suspend fun logOut(): FirebaseUser? {
        dataSource.signOut()
        return null
    }

    suspend fun uploadImage(bitmap: Bitmap): FirebaseUser? {
        //El bite convertirlo en un arreglo de bytes
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)      //Compresion de la clase con el mismo tamaño
        //Traer el arreglo de bytes
        val data = baos.toByteArray()
        //Usuario logueado
        val user = dataSource.currentUser
        //Referencia de la imagen en el storage con el ID personalizado -- En el storage de firebase se sube esta imagen
        val profileRef = dataSourceStorage.child("${user!!.uid}.jpg")
        profileRef.putBytes(data).await()                                  //Bytes en data
        //alamcenamos el uri de la imagen
        var uri = profileRef.downloadUrl.await()
        //Referencia de la imagen
        val profileUpdate = userProfileChangeRequest {
            photoUri = uri
        }
        //Actulizar la imagen en el perfil del usuario
        user!!.updateProfile(profileUpdate).await()
        return user
    }

}