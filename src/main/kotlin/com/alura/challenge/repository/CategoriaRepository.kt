package com.alura.challenge.repository

import com.alura.challenge.model.CategoriaModel
import com.alura.challenge.model.DespesasModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CategoriaRepository : JpaRepository<CategoriaModel, Int> {
    fun existsByTitulo(titulo: String): Boolean
    fun findByTituloContaining(titulo: String)
//    fun findByTituloId(id: Int)
}