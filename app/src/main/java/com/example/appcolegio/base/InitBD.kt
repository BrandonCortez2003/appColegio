package com.example.appcolegio.base

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.appcolegio.utils.appConfig

class InitBD:SQLiteOpenHelper(appConfig.CONTEXT,
                              appConfig.BDNAME,
                              null,
                              appConfig.VERSION) {
    override fun onCreate(bd: SQLiteDatabase) {
        bd.execSQL("create table tb_distrito" +
                "(" +
                "cod_dis integer primary key autoincrement," +
                "nomdis varchar(30))")

        //crear tabla
        bd.execSQL("create table tb_docente" +
                      "(" +
                      "cod integer primary key autoincrement," +
                      "nom varchar(35)," +
                      "pat varchar(35)," +
                      "mat varchar(35)," +
                      "sexo varchar(15)," +
                      "hijos int," +
                      "sueldo double," +
                      "foto varchar(3),"+
                      "direccion varchar(35)," +
                      "codDis int)")

        //ingresar 3 distritos
        bd.execSQL("insert into tb_distrito values(null,'Comas')")
        bd.execSQL("insert into tb_distrito values(null,'Independencia')")
        bd.execSQL("insert into tb_distrito values(null,'Surco')")


        //ingresar 3 docentes
        bd.execSQL("insert into tb_docente values(null,'Ana','Soto','Castro'," +
                    "'Femenino',2,2504,'d1','prueba1',1)")
        bd.execSQL("insert into tb_docente values(null,'Alicia','Iglesias','Luna'," +
                "'Femenino',1,3504,'d2','prueba2',1)")
        bd.execSQL("insert into tb_docente values(null,'Gloria','Torres','Siuce'," +
                "'Femenino',0,3504,'d3','prueba3',1)")
        bd.execSQL("insert into tb_docente values(null,'Luis','Malpartida','Peña'," +
                "'Masculino',2,7850,'d4','prueba4',2)")

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }


}