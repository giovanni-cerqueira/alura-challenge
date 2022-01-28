package com.alura.challenge.repository

import com.alura.challenge.model.DespesasModel
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime


@Repository
interface DespesasRepository : JpaRepository<DespesasModel, Int> {

    fun save(id: Int)
    fun existsByDescricao(descricao: String): Boolean
    fun findByDescricaoContaining(descricao: String): List<DespesasModel>
}