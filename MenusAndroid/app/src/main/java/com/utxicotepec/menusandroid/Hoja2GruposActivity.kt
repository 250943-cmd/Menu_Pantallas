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

class Hoja2GruposActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hoja2_grupos)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(barras.left, barras.top, barras.right, barras.bottom)
            insets
        }

        setSupportActionBar(findViewById<MaterialToolbar>(R.id.toolbar))

        txtResultado = findViewById(R.id.txtResultado)

        // ZONA A: aquí van las instrucciones del tutorial que van dentro de onCreate
        // Nota: Para los menús de opciones básicos (ActionBar/Toolbar), no se requiere inicializar nada aquí.
    }

    // ZONA B: aquí van las funciones del tutorial que van FUERA de onCreate

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_hoja2, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.opcion_rojo -> {
                item.isChecked = true
                txtResultado.text = "Seleccionaste: Rojo"
                true
            }
            R.id.opcion_azul -> {
                item.isChecked = true
                txtResultado.text = "Seleccionaste: Azul"
                true
            }
            R.id.opcion_verde -> {
                item.isChecked = true
                txtResultado.text = "Seleccionaste: Verde"
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
