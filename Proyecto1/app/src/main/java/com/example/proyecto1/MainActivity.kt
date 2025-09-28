package com.example.proyecto1

import android.R.attr.button
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nombre = findViewById<EditText>(R.id.Nombre)
        val apellido = findViewById<EditText>(R.id.Apellido)
        val spiner = findViewById<Spinner>(R.id.Ciudades)
        val lista = arrayOf("Toledo", ("Madrid"), "Barcelona")
        val adaptador = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista)
        spiner.adapter=adaptador
        val estudiante = findViewById<RadioButton>(R.id.Estudiante)
        val autonomo = findViewById<RadioButton>(R.id.Autonomo)
        val empleado = findViewById<RadioButton>(R.id.Empleado)
        val si= findViewById<CheckBox>(R.id.Si)
        val no= findViewById<CheckBox>(R.id.No)
        val boton = findViewById<Button>(R.id.Boton)
        val respuesta = findViewById<TextView>(R.id.Respuesta)
        boton.setOnClickListener{

            boton.setOnClickListener{
                var res = ""
                val nom = nombre.text.toString()
                val ape = apellido.text.toString()
                if (nom.isNotEmpty()) res += "Nombre: $nom "
                if (ape.isNotEmpty()) res += "Apellido: $ape "

                res += "Ciudad: ${spiner.selectedItem} "

                if (estudiante.isChecked) res += "Estado: Estudiante "
                if (empleado.isChecked) res += "Estado: Empleado "
                if (autonomo.isChecked) res += "Estado: Autónomo "

                var busqueda = ""
                if (si.isChecked) busqueda += "Si "
                if (no.isChecked) busqueda += "No"
                if (busqueda.isNotEmpty()) res += "En busca de trabajo: $busqueda"

                respuesta.text = res
            }


        }

    }
}