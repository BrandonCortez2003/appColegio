package com.example.appcolegio.adaptador

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appcolegio.R
import com.example.appcolegio.entidad.Docente

class DocenteAdapter(var data:ArrayList<Docente>): RecyclerView.Adapter<ViewDocente>() {
    //1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewDocente {
        //inflar
        var vista=LayoutInflater.from(parent.context).inflate(R.layout.item_docente,parent,false)
        return ViewDocente(vista)
    }
    override fun getItemCount(): Int {
       return data.size
    }
    //2
    override fun onBindViewHolder(holder: ViewDocente, position: Int) {
        holder.tvCodigo.text=data.get(position).codigo.toString()
        holder.tvNombre.text=data.get(position).nombre
        holder.tvPaterno.text=data.get(position).paterno
        holder.tvMaterno.text=data.get(position).materno
        //contexto de ViewDocente
        var contexto:Context=holder.itemView.context
        //identificador para la IMG
        var IMG=-1
        IMG=contexto.resources.getIdentifier(data.get(position).foto,"drawable",contexto.packageName)
        holder.imgFoto.setImageResource(IMG)


    }
}