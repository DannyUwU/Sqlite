package com.javier.sqlite.controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.javier.sqlite.AyudanteBaseDeDatos;
import com.javier.sqlite.modelos.Estudiante;

public class EstudianteController {
    private AyudanteBaseDeDatos ayudanteBaseDeDatos;
    private String NOMBRE_TABLA = "estudiantes";

    public EstudianteController(Context context) {
        ayudanteBaseDeDatos = new AyudanteBaseDeDatos(context);
    }
    public long nuevoEstudiante(Estudiante estudiante){
        //Para escribir en la bd write
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();
        ContentValues valoresAInsertar = new ContentValues();
        valoresAInsertar.put("nombre",estudiante.getNombre());
        valoresAInsertar.put("carrera",estudiante.getCarrera());
        valoresAInsertar.put("semestre",estudiante.getSemestre());
        return baseDeDatos.insert(NOMBRE_TABLA,null,valoresAInsertar);
    }
}
