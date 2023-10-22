package com.example.appcolegio.adaptador

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appcolegio.R

class ViewDocente(item:View):RecyclerView.ViewHolder(item) {
    //declarar 4 atributos (TextView)
    var tvCodigo:TextView
    var tvNombre:TextView
    var tvPaterno:TextView
    var tvMaterno:TextView
    var imgFoto:ImageView
    //refrenciar atributos con los controles de la pantalla
    init{
        tvCodigo=item.findViewById(R.id.tvCodigo)
        tvNombre=item.findViewById(R.id.tvNombre)
        tvPaterno=item.findViewById(R.id.tvPaterno)
        tvMaterno=item.findViewById(R.id.tvMaterno)
        imgFoto=item.findViewById(R.id.imgFoto)
    }
}