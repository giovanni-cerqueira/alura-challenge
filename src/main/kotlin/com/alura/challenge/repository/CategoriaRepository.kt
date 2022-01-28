package com.alura.challenge.repository

import com.alura.challenge.controller.request.PostCategoriaRequest
import com.alura.challenge.model.CategoriaModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoriaRepository : JpaRepository<CategoriaModel, Int> {
    abstract fun save(categoria: PostCategoriaRequest)
}