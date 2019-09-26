package com.javier.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.javier.sqlite.controllers.EstudianteController;
import com.javier.sqlite.modelos.Estudiante;

public class MainActivity extends AppCompatActivity {

    EditText etNombre,etCarrera,etSemestre;
    Button btnCrear;
    //controler:
    EstudianteController estudianteController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombre = findViewById(R.id.etNombre);
        etCarrera = findViewById(R.id.etCarrera);
        etSemestre = findViewById(R.id.etSemestre);
        btnCrear = findViewById(R.id.btnCrear);

        estudianteController = new EstudianteController(MainActivity.this);
        //on clic boton:
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //recuperar los textos:
                String nombre = etNombre.getText().toString();
                String carrera = etCarrera.getText().toString();
                String semestreCadena = etSemestre.getText().toString();
                //validar que no queden vacios:
                if ("".equals(nombre)){
                    etNombre.setError("debes ingresar el nombre");
                    etNombre.requestFocus();
                    return;
                }
                if ("".equals(carrera)){
                    etCarrera.setError("debes ingresar la carrera");
                    etCarrera.requestFocus();
                    return;
                }
                if ("".equals(semestreCadena)){
                    etSemestre.setError("debes ingresar el semestre");
                    etSemestre.requestFocus();
                    return;
                }
                //Se esta validando que sea numero mediante xml (imputType)
                int semestre = Integer.parseInt(etSemestre.getText().toString());
                //si llegamos aqui todo lo de arriba esta ok:
                Estudiante estudiante = new Estudiante(nombre,carrera,semestre);
                long creado = estudianteController.nuevoEstudiante(estudiante);
                if (creado == -1){
                    //error en la insercion
                    Toast.makeText(MainActivity.this,"error al insertar",Toast.LENGTH_LONG).show();
                }
                else{
                    //si esta ok finalisar:
                    //finish();
                    Toast.makeText(MainActivity.this,"se inserto el estudiante con exito",Toast.LENGTH_LONG).show();

                }

            }
        });

    }//fin onCreate
}
