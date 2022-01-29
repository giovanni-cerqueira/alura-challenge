package com.alura.challenge.repository

import com.alura.challenge.model.ReceitasModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface ReceitasRepository : JpaRepository<ReceitasModel, Int> {

    fun existsByDescricao(descricao: String): Boolean
    fun findByDescricao(descricao: LocalDateTime): Boolean
    fun findByDescricaoContaining(descricao: String): List<ReceitasModel>

}