package com.alura.challenge.repository

import com.alura.challenge.controller.request.PostContasRequest
import com.alura.challenge.model.ContaUsuarioModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContaUsuarioRepository : JpaRepository<ContaUsuarioModel, Int> {
    abstract fun save(conta: PostContasRequest)
}