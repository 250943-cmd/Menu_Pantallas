package com.utxicotepec.menusandroid

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class Hoja3ContextualActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hoja3_contextual)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(barras.left, barras.top, barras.right, barras.bottom)
            insets
        }

        setSupportActionBar(findViewById<MaterialToolbar>(R.id.toolbar))

        txtResultado = findViewById(R.id.txtResultado)

        // ZONA A: Registrar el TextView para que reaccione al mantenerlo presionado
        registerForContextMenu(txtResultado)
    }

    // ZONA B: funciones fuera de onCreate

    // Carga el menú flotante desde XML
    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_hoja3, menu)
    }

    // Detecta cuál opción (Editar o Eliminar) se presionó
    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.opcion_editar -> {
                txtResultado.text = "Seleccionaste: Editar"
                true
            }
            R.id.opcion_eliminar -> {
                txtResultado.text = "Seleccionaste: Eliminar"
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}
