package com.alura.challenge.repository

import com.alura.challenge.model.DespesasModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface DespesasRepository : JpaRepository<DespesasModel, Int> {

    fun existsByDescricao(descricao: String): Boolean
    fun findByDescricaoContaining(descricao: String): List<DespesasModel>

}