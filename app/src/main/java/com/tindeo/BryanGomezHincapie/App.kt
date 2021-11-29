package com.tindeo.BryanGomezHincapie

import android.app.Application
import com.tindeo.BryanGomezHincapie.di.dataSourceModule
import com.tindeo.BryanGomezHincapie.di.repoModule
import com.tindeo.BryanGomezHincapie.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

// para hacer cosas custom como habilitar un inyector de dependencias se crear el archivo app para sobreescribir Application, se agrega en manifest la propiedad name: ".App"
class App: Application() {
    // app creando
    override fun onCreate() {
        super.onCreate()
        // inicializar Koin, habilitacion de depencias con Koin
        startKoin{
            // contexto general de la app
            androidContext(this@App)
            // Modulo de inyector de dependencias que usaremos, una lista de diferente modulos
            modules(listOf(dataSourceModule, repoModule, viewModelModule))
        }
    }
}