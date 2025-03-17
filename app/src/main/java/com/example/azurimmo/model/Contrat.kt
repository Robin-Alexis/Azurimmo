package com.example.azurimmo.model

import java.time.LocalDate

data class Contrat(
    val id: Int,
    val dateDebut: LocalDate,
    val dateFin: LocalDate?,
    val appartement: Appartement,
    val locataire: Locataire
)
