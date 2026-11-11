package com.utxicotepec.menusandroid

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class Hoja1OpcionesActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hoja1_opciones)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(barras.left, barras.top, barras.right, barras.bottom)
            insets
        }

        setSupportActionBar(findViewById<MaterialToolbar>(R.id.toolbar))

        txtResultado = findViewById(R.id.txtResultado)

        // ZONA A: aquí van las instrucciones del tutorial que van dentro de onCreate
    }

    // ZONA B: aquí van las funciones del tutorial que van FUERA de onCreate
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_hoja1, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_buscar -> {
                txtResultado.text = "Seleccionaste: Buscar"
                true
            }
            R.id.action_configuracion -> {
                txtResultado.text = "Seleccionaste: Configuración"
                true
            }
            R.id.action_ayuda -> {
                    txtResultado.text = "Seleccionaste: Ayuda"
                    true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
