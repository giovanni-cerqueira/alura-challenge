package com.alura.challenge.service

import com.alura.challenge.model.ContaUsuarioModel
import com.alura.challenge.repository.ContaUsuarioRepository
import org.springframework.stereotype.Service

@Service
class ContaUsuarioService(
    val contaUsuarioRepository: ContaUsuarioRepository
) {

    fun getAll(): List<ContaUsuarioModel> {
        return contaUsuarioRepository.findAll()
    }

    fun findById(id: Int): ContaUsuarioModel {
        return contaUsuarioRepository.findById(id).orElseThrow()
    }

    fun create(conta: ContaUsuarioModel) {
        contaUsuarioRepository.save(conta)
    }

}