package com.example.appcolegio.controlador

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.appcolegio.entidad.Docente
import com.example.appcolegio.utils.appConfig

class ArregloDocente {
    fun listado():ArrayList<Docente>{
        var data=ArrayList<Docente>()
        //abrir el acceso a la base de datos en modo lectura
        var cn:SQLiteDatabase=appConfig.BD.readableDatabase
        //sentencia SQL
        var SQL="select *from tb_docente"
        //ejecutar sentencia SQL
        //guardar el valor de retorno del método rawQuery
        //en un objeto de tipo Cursor
        var rs=cn.rawQuery(SQL,null)
        //bucle para realizar recorido  sobre el objeto rs
        while(rs.moveToNext()) {
            //crear objeto de la clase Docente
            var bean = Docente(
                rs.getInt(0),
                rs.getString(1), rs.getString(2),
                rs.getString(3), rs.getString(4),
                rs.getInt(5), rs.getDouble(6),
                rs.getString(7), rs.getString(8),
                rs.getInt(9))
            //enviar objeto al arreglo data
            data.add(bean)
        }
        return data
    }
    fun adicionar(bean:Docente):Int{
        var salida=-1
        //abrir acceso a la base de datos en modo escritura
        var cn=appConfig.BD.writableDatabase
        //crear objeto de la clase ContentValues
        var row=ContentValues()
        //claves
        row.put("nom",bean.nombre)
        row.put("pat",bean.paterno)
        row.put("mat",bean.materno)
        row.put("sexo",bean.sexo)
        row.put("hijos",bean.hijos)
        row.put("sueldo",bean.sueldo)
        row.put("foto",bean.foto)
        row.put("direccion",bean.direccion)
        row.put("codDis",bean.codigoDistrito)
        //invocar al método insert
        salida=cn.insert("tb_docente","cod",row).toInt()
        return salida
    }

}




