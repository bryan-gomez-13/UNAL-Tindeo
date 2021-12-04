package com.tindeo.BryanGomezHincapie.ui.activities

import android.animation.Animator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.tindeo.BryanGomezHincapie.data.models.Comment
import com.tindeo.BryanGomezHincapie.data.models.Product
import com.tindeo.BryanGomezHincapie.data.models.StoreInfo
import com.tindeo.BryanGomezHincapie.databinding.ActivitySplashBinding
import com.tindeo.BryanGomezHincapie.ui.viewmodels.LoginViewModel
import com.tindeo.BryanGomezHincapie.ui.viewmodels.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    //Crear repositore
    private val splashViewModel: SplashViewModel by viewModel()

    private val loginViewModel: LoginViewModel by viewModel()

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
        // Insertar los consinviros
        splashViewModel.insert(
            StoreInfo(
                "1",
                "La curiteña",
                "https://cdn.pixabay.com/photo/2014/04/02/13/07/choctaw-bluff-305932_960_720.jpg",
                "Calle 20 #10-15 Bogotá",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                null,
                null,
                5,
            ), listOf(
                Comment("1","Bryan Gomez","Good store","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","27-11-2021","https://cdn.pixabay.com/photo/2014/05/05/19/52/charcuterie-338498_960_720.jpg",70,10,5),
                Comment("2","Carlos Vesga","Bad store","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","26-11-2021","https://cdn.pixabay.com/photo/2014/05/05/19/52/charcuterie-338498_960_720.jpg",10,70,1),
                Comment("3","Sisa","So so store","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","25-11-2021","https://cdn.pixabay.com/photo/2014/05/05/19/52/charcuterie-338498_960_720.jpg",50,50,3)
            ), listOf(
                Product("1","Product 1","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","$10000", "https://cdn.pixabay.com/photo/2017/03/23/19/57/asparagus-2169305_960_720.jpg"),
                Product("2","Product 2","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","$10000", "https://cdn.pixabay.com/photo/2013/06/09/06/07/meat-123668_960_720.jpg"),
                Product("3","Product 3","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","$10000", "https://cdn.pixabay.com/photo/2014/05/05/19/52/charcuterie-338498_960_720.jpg"),
                Product("4","Product 4","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","$10000", "https://cdn.pixabay.com/photo/2016/05/04/11/20/cheese-1371196_960_720.jpg"),
                Product("5","Product 5","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","$10000", "https://cdn.pixabay.com/photo/2016/12/06/18/27/cheese-1887233_960_720.jpg"),
                Product("6","Product 6","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","$10000", "https://cdn.pixabay.com/photo/2017/03/23/19/57/asparagus-2169305_960_720.jpg"),
                Product("7","Product 7","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","$10000", "https://cdn.pixabay.com/photo/2017/03/23/19/57/asparagus-2169305_960_720.jpg"),
                Product("8","Product 8","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","$10000", "https://cdn.pixabay.com/photo/2017/03/23/19/57/asparagus-2169305_960_720.jpg"),
                Product("9","Product 9","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","$10000", "https://cdn.pixabay.com/photo/2017/03/23/19/57/asparagus-2169305_960_720.jpg"),
                Product("10","Product 10","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","$10000", "https://cdn.pixabay.com/photo/2017/03/23/19/57/asparagus-2169305_960_720.jpg")
            )
        )
        loginViewModel.loggedIn()
        binding.splashAnimation.playAnimation()
    }

    private fun events(){
        binding.splashAnimation.addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {
                // Observando si el usuario esta logueado
                loginViewModel.user.observe(this@SplashActivity, Observer { user ->
                    if(user == null){
                        val intent = Intent(applicationContext, MainActivity::class.java)
                        startActivity(intent)
                    }else{
                        val intent = Intent(applicationContext, HomeActivity::class.java)
                        startActivity(intent)
                    }
                    finish()
                })
            }

            override fun onAnimationCancel(animation: Animator?) {

            }

            override fun onAnimationRepeat(animation: Animator?) {

            }

        })
    }
}