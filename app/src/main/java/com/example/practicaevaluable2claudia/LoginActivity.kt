package com.example.practicaevaluable2claudia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    // Constantes con el usuario y la contraseña correctos
    companion object {
        private const val MYUSER = "admin"
        private const val MYPASS = "1234"
    }

    // Estas son las referencias a las vistas del layout
    private lateinit var editUsuario: EditText
    private lateinit var editPassword: EditText
    private lateinit var botonValidar: Button

    // Inflamos y mostramos el diseño del activity_login.xml
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Cargamos el diseño que hicimos en el xml del login
        setContentView(R.layout.activity_login)

        // Asociamos cada vista del xml con su variable usando su id correspondiente
        editUsuario = findViewById(R.id.edit_usuario)
        editPassword = findViewById(R.id.edit_password)
        botonValidar = findViewById(R.id.boton_validar)

        // Listener del botón, que se ejecuta al hacer clic en "Validar"
        botonValidar.setOnClickListener {
            // Leemos el texto que se ha introducido quitando los espacios vacíos a los lados con trim()
            val usuario = editUsuario.text.toString().trim()
            val password = editPassword.text.toString().trim()

            // Validamos las credenciales
            if (usuario == MYUSER && password == MYPASS) {
                /* Si las credenciales son correctas creamos un intent explicito
                para ir a la siguiente pantalla, es decir, a PrincipalActivity */
                val intent = Intent(this, PrincipalActivity::class.java)

                // Enviamos los datos a la siguiente activity
                intent.putExtra("usuario", usuario)
                intent.putExtra("password", password)

                startActivity(intent)
            } else {
                /* Si las credenciales no coinciden se mostrará este mensaje en la pantalla
                con el aviso que tenemos en el fichero strings.xml, es decir, este error
                'Usuario o contraseña incorrectos' */
                Toast.makeText(this, getString(R.string.mensaje_error), Toast.LENGTH_SHORT).show()
            }
        }
    }
}