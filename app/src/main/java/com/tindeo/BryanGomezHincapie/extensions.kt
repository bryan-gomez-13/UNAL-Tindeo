package com.tindeo.BryanGomezHincapie
import android.util.Patterns
//Caracteristica de kotlin que es hacer extensiones de metodos
fun CharSequence?.isValidEmail() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()


