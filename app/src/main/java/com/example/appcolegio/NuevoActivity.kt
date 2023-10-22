package com.example.appcolegio

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appcolegio.controlador.ArregloDistrito
import com.example.appcolegio.controlador.ArregloDocente
import com.example.appcolegio.entidad.Docente
import com.google.android.material.textfield.TextInputEditText

abstract class NuevoActivity() : AppCompatActivity(), AdapterView.OnItemClickListener{
    private lateinit var txtNombre: TextInputEditText
    private lateinit var txtPaterno: TextInputEditText
    private lateinit var txtMaterno: TextInputEditText
    private lateinit var txtHijos: TextInputEditText
    private lateinit var txtSueldo: TextInputEditText
    private lateinit var txtDireccion: TextInputEditText
    private lateinit var atvSexo: AutoCompleteTextView
    private lateinit var atvDistrito: AutoCompleteTextView
    private lateinit var btnGrabar: Button
    private lateinit var btnSalir: Button
    var posDis=1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nuevo_docente)
        txtNombre = findViewById(R.id.txtNombre)
        txtPaterno = findViewById(R.id.txtPaterno)
        txtMaterno = findViewById(R.id.txtMaterno)
        txtHijos = findViewById(R.id.txtHijos)
        txtSueldo = findViewById(R.id.txtSueldo)
        txtDireccion = findViewById(R.id.txtDireccion)
        atvSexo = findViewById(R.id.atvSexo)
        atvDistrito = findViewById(R.id.atvDistrito)
        btnGrabar = findViewById(R.id.btnGrabar)
        btnSalir = findViewById(R.id.btnSalir)
        //

        //
        btnGrabar.setOnClickListener { grabar() }
        btnSalir.setOnClickListener { salir() }
        atvDistrito.setOnItemClickListener(this)

        //cargar sexo
        val sexos = resources.getStringArray(R.array.arregloSexos)
        //adaptador
        val adaptador = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, sexos
        )
        //mostrar adaptador
        atvSexo.setAdapter(adaptador)

        cargarDistritos()
    }

    fun grabar() {
        //variables
        var nom = "";
        var pat = "";
        var mat = "";
        var sexo = ""
        var hijos = 0;
        var sue: Double;
        var dir = "";
        var codDis: Int
        var nomSexo = ""
        //leer cajas
        nom = txtNombre.text.toString()
        pat = txtPaterno.text.toString()
        mat = txtMaterno.text.toString()
        nomSexo = atvSexo.text.toString()
        hijos = txtHijos.text.toString().toInt()
        sue = txtSueldo.text.toString().toDouble()
        dir = txtDireccion.text.toString()
        codDis = 1

        //crear objeto de la clase Docente
        var doc = Docente(0, nom, pat, mat, sexo, hijos, sue, "", dir, posDis)


        //invocar al método adicionar
        var estado = ArregloDocente().adicionar(doc)

        //validar estado
        if (estado > 0)
            Toast.makeText(this, "Docente registrado", Toast.LENGTH_LONG).show()
        else
            Toast.makeText(this, "Error en el registro", Toast.LENGTH_LONG).show()

    }

    fun salir() {

        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }

    fun cargarDistritos() {
        //invocar al metodo listadoDistritos
        var data = ArregloDistrito().listadoDistrito()
        //crear un adaptador con los valores de data
        var adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        //enviar el objeto "adaptador" al atributo
        atvDistrito.setAdapter(adaptador)
    }

}