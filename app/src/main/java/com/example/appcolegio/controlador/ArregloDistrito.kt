package com.example.appcolegio.controlador

import android.database.sqlite.SQLiteDatabase
import com.example.appcolegio.entidad.Distrito

import com.example.appcolegio.utils.appConfig

class ArregloDistrito {
    fun listadoDistrito():ArrayList<String>{
        var data=ArrayList<String>()
        var cn: SQLiteDatabase = appConfig.BD.readableDatabase
        var SQL="select *from tb_distrito"
        var rs=cn.rawQuery(SQL,null)
        while(rs.moveToNext()) {
            var bean = rs.getString(1)
            data.add(bean)
        }
        return data
    }

}