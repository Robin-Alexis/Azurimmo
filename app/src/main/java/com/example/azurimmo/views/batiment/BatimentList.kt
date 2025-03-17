package com.example.azurimmo.views.batiment

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.azurimmo.viewsmodel.batiment.BatimentViewModel

@Composable
fun BatimentList(viewModel: BatimentViewModel = viewModel(), navController: NavController) {
    // Observer les données de manière réactive
    val batiments by viewModel.batiments.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    when {
        isLoading -> CircularProgressIndicator(modifier = Modifier.padding(16.dp))
        errorMessage != null -> Text(
            text = errorMessage!!,
            color = Color.Red,
            modifier = Modifier.padding(16.dp)
        )
        else -> {
            LazyColumn(modifier = Modifier.padding(8.dp)) {
                // Ajout du titre en premier élément de la liste
                item {
                    Text(
                        text = "Liste des bâtiments",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                // Liste des bâtiments
                items(batiments) { batiment ->
                    BatimentCard(batiment = batiment, navController = navController)
                }
            }
        }
    }
}
