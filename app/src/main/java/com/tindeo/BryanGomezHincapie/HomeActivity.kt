package com.tindeo.BryanGomezHincapie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.tindeo.BryanGomezHincapie.databinding.ActivityHomeBinding

class  HomeActivity : AppCompatActivity() {

    private lateinit var binding:ActivityHomeBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Layout con toolbar
        setSupportActionBar(binding.toolbar)
        //Asistente de kotlin - Busca el navigarion controller por ID
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        //Crear appBarconfiguration con su respectivo BAR
        //Quitar "setOf" la flecha ya que todos lso fragmentos estan en el mismo nivel
        appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.productFragment, R.id.commentFragment, R.id.profileFragment))
        //Seteo
        setupActionBarWithNavController(navController, appBarConfiguration)
        //Cual va a hacer control
        binding.bottomNavigation.setupWithNavController(navController)
    }

    //Flecha arriba para devolverse con el navegation bar
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}