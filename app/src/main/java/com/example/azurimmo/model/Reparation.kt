package com.example.azurimmo.model

import java.time.LocalDate

data class Reparation(
    val id: Int,
    val description: String,
    val date: LocalDate,
    val appartement: Appartement,
    val societe: Societe,
    val type: Type
)
