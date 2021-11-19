package com.tindeo.BryanGomezHincapie

import android.animation.Animator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tindeo.BryanGomezHincapie.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Crear layout
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        events()
        // Este es un comentario de prueba
        // Segundo commit por carlos vesga
    }

    private fun init(){
        //plas animation - carpeta de imagenes
        //binding.splashAnimation.imageAssetsFolder = "images"
        //iniciar animacion
        binding.splashAnimation.playAnimation()
    }

    private fun events(){
        binding.splashAnimation.addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {
                //intension explicita
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

            override fun onAnimationCancel(animation: Animator?) {

            }

            override fun onAnimationRepeat(animation: Animator?) {

            }

        })
    }
}