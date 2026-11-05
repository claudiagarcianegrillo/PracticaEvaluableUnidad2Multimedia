package com.example.practicaevaluable2claudia

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent

class PrincipalActivity : AppCompatActivity() {

    // Declaramos la variable para el campo de texto de bienvenida
    private lateinit var textoDatos: TextView
    private lateinit var btnDesconectar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Carga el diseño del activity principal
        setContentView(R.layout.activity_principal)

        // Asociamos los componentes con su id del xml
        textoDatos = findViewById(R.id.texto_datos)
        btnDesconectar = findViewById(R.id.btn_desconectar)

        // Recuperamos los datos enviados desde el login a través delintent
        val usuario = intent.getStringExtra("usuario")

        // Mostramos un mensaje de bienvenida personalizado con el usuario recibido
        // Siempre que el usuario sea diferente a nulo o a vacío entrará
        if (!usuario.isNullOrEmpty()) {
            textoDatos.text = "¡Hola, $usuario! Aquí tienes una rutina de Skincare"
        } else {

            /* Esto es un mensaje por defecto en caso */
            textoDatos.text = "¡Bienvenid@ a LumiSkin!"
        }

        // Botón de desconectarse
        btnDesconectar.setOnClickListener {
            // Creamos el Intent para ir a LoginActivity
            val intent = Intent(this, LoginActivity::class.java)

             /* Esto sirve para borra el historial para que, si le dan al botón
             "atrás" del móvil, no vuelvan a entrar aquí */
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            // Iniciamos la actividad de inicio de sesión
            startActivity(intent)

            // Cierra la actividad principal actual
            finish()
        }
    }
}