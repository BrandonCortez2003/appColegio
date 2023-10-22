package com.example.appcolegio.utils

import android.app.Application
import android.content.Context
import com.example.appcolegio.base.InitBD

class appConfig:Application() {
    //variables global
    companion object{
        lateinit var CONTEXT:Context
        lateinit var BDNAME:String
        var VERSION:Int=1
        lateinit var BD:InitBD
    }
    //inicializar variables global
    override fun onCreate() {
        super.onCreate()
        //inicializar variables global
        BDNAME="consorcio.bd"
        CONTEXT=applicationContext
        BD=InitBD()
    }


}