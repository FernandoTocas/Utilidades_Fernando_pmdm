package es.fpsumma.dam2.utilidades.ui.screens.asignaturas

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import es.fpsumma.dam2.utilidades.ui.viewmodel.AsignaturaViewModel
import java.lang.reflect.Modifier
import android.text.Layout.Alignment
import androidx.compose.ui.text.font.FontWeight

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListadoAsignaturasScreen(
    navController: NavController,
    vm: AsignaturaViewModel,
    modifier: Modifier= Modifier
) {
    val asignatura by rememberSaveable { mutableStateOf("") }
    var trimestre by rememberSaveable { mutableStateOf("1TRI") }
    val nota by rememberSaveable { mutableStateOf("") }

    fun handleAddAsignatura(){
        trimestre=""
    }

    val opciones = listOf("1TRI", "2TRI", "3TRI")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Listado de tareas") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) {
    }
    Column(modifier = androidx.compose.ui.Modifier
        .fillMaxSize()
        .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)) {

        OutlinedTextField(
            value = asignatura,
            onValueChange = { asignatura = it },
            label = { Text("ASIGNATURA") },
            singleLine = true,
            modifier = androidx.compose.ui.Modifier.fillMaxWidth()
        )
        Spacer(androidx.compose.ui.Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Trimestre:", fontWeight = FontWeight.Medium)

            Row {
                opciones.forEach { texto->
                    Row() {
                        RadioButton(
                            selected = (trimestre == texto),
                            onClick = { trimestre = texto }
                        )
                        Text(texto)
                    }
                }
            }
        }
        Spacer(androidx.compose.ui.Modifier.height(8.dp))

        OutlinedTextField(
            value = nota,
            onValueChange = { nota = it },
            label = { Text("Nota") },
            singleLine = false,
            modifier = androidx.compose.ui.Modifier.fillMaxWidth()
        )
        Spacer(androidx.compose.ui.Modifier.height(8.dp))

        Button(
            onClick = ::handleAddAsignatura,
            modifier = androidx.compose.ui.Modifier.fillMaxWidth()
        ) { Text("Guardar Asignatura") }
        HorizontalDivider(modifier.padding(vertical = 16.dp))
    }
}

