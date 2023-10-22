package com.example.appcolegio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appcolegio.adaptador.DocenteAdapter
import com.example.appcolegio.controlador.ArregloDocente

class MainActivity : AppCompatActivity() {
    private lateinit var rvDocentes:RecyclerView
    private lateinit var btnNuevo:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvDocentes=findViewById(R.id.rvDocentes)
        btnNuevo=findViewById(R.id.btnNuevo)
        btnNuevo.setOnClickListener {nuevo()}

        //invocar al método listado
        var datos=ArregloDocente().listado()
        //crear objeto de la clase DocenteAdapter
        var adaptador=DocenteAdapter(datos)
        //estilo tipo fila para visualizar datos en rvDocentes
        rvDocentes.layoutManager=LinearLayoutManager(this)
        //rvDocentes.layoutManager=GridLayoutManager(this,3)
        //mostrar el valor del objeto adaptador al atributo rvDocentes
        rvDocentes.adapter=adaptador
    }
    fun nuevo(){
        val intent=Intent(this,NuevoActivity::class.java)
        startActivity(intent)
    }

}