package com.example.menuextra // Cambia esto por tu paquete si es diferente

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MenuDesplegableConIconos()
                }
            }
        }
    }
}

@Composable
fun MenuDesplegableConIconos() {
    var expandido by remember { mutableStateOf(false) }
    var textoSeleccionado by remember { mutableStateOf("Aquí va a aparecer la opción") }

    Column(
        modifier = Modifier.fillMaxSize().padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = textoSeleccionado,
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(24.dp))

        Box {
            Button(onClick = { expandido = true }) {
                Text("Mostrar Menú con Íconos")
            }

            DropdownMenu(
                expanded = expandido,
                onDismissRequest = { expandido = false }
            ) {
                // Primera opción con ícono de persona
                DropdownMenuItem(
                    text = { Text("Perfil") },
                    leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                    onClick = {
                        textoSeleccionado = "Elegiste: Perfil"
                        expandido = false
                    }
                )

                HorizontalDivider() // Divisor de secciones

                // Segunda opción con ícono de engranaje
                DropdownMenuItem(
                    text = { Text("Configuración") },
                    leadingIcon = { Icon(Icons.Default.Settings, contentDescription = null) },
                    onClick = {
                        textoSeleccionado = "Elegiste: Configuración"
                        expandido = false
                    }
                )

                // Tercera opción con ícono de corazón
                DropdownMenuItem(
                    text = { Text("Favoritos") },
                    leadingIcon = { Icon(Icons.Default.Favorite, contentDescription = null) },
                    onClick = {
                        textoSeleccionado = "Elegiste: Favoritos"
                        expandido = false
                    }
                )
            }
        }
    }
}