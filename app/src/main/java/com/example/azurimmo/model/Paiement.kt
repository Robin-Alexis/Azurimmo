package com.example.azurimmo.model

import java.time.LocalDate

data class Paiement(
    val id: Int,
    val datePaiement: LocalDate,
    val montant: Double,
    val contrat: Contrat
)
