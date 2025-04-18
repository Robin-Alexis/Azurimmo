package com.example.azurimmo.api
import com.example.azurimmo.model.Appartement
import retrofit2.http.GET
import com.example.azurimmo.model.Batiment
import com.example.azurimmo.model.Contrat
import com.example.azurimmo.model.Locataire
import com.example.azurimmo.model.Paiement
import com.example.azurimmo.model.Reparation
import retrofit2.http.Path

interface ApiService {
    @GET("/batiments")
    suspend fun getBatiments(): List<Batiment>

    @GET("/batiment/{id}")
    suspend fun getBatiment(@Path("id") id: Int): retrofit2.Response<Batiment>

    @GET("/appartement/batiment/{batimentId}")
    suspend fun getAppartementsByBatimentId(@Path("batimentId") batimentId: Int): List<Appartement>

    @GET("/appartements")
    suspend fun getAppartements(): List<Appartement>

    @GET("/contrats")
    suspend fun getContrats(): List<Contrat>

    @GET("/locataires")
    suspend fun getLocataires(): List<Locataire>

    @GET("/paiements")
    suspend fun getPaiements(): List<Paiement>

    @GET("/reparations")
    suspend fun getReparations(): List<Reparation>
}