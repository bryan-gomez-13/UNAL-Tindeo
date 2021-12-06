package com.tindeo.BryanGomezHincapie.ui.viewmodels

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.tindeo.BryanGomezHincapie.data.models.StoreInfo
import com.tindeo.BryanGomezHincapie.data.repositories.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val repo: UserRepository): ViewModel() {
    //                                 Devuelve el repo
    private var _user: MutableLiveData<FirebaseUser?> = MutableLiveData()
    //Getter
    val user: LiveData<FirebaseUser?> get() = _user

    private var _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> get() = _error

    fun singUp(email:String, name:String, password:String, apellidos:String, celular:String){
        viewModelScope.launch {
            try {
                _user.postValue(repo.signUp(email,name,password,apellidos,celular))
            }catch (e: Error){
                _error.postValue(e.message)
            }
        }
    }

    fun login(email:String, pass:String){
        viewModelScope.launch {
            try {
                _user.postValue(repo.logIn(email,pass))
            }catch (e: Error){
                _error.postValue(e.message)
            }
        }
    }

    fun logOut(){
        viewModelScope.launch {
            _user.postValue(repo.logOut())
        }
    }

    fun loggedIn(){
        viewModelScope.launch {
            _user.postValue(repo.loggedIn())
        }
    }

    fun uploadImage(bitmap: Bitmap){
        viewModelScope.launch {
            _user.postValue(repo.uploadImage(bitmap))
        }
    }

}