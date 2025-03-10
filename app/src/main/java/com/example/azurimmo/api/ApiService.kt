package com.example.azurimmo.api
import retrofit2.http.GET
import com.example.azurimmo.model.Batiment

interface ApiService {
    @GET("/batiments")
    suspend fun getBatiments(): List<Batiment>
}