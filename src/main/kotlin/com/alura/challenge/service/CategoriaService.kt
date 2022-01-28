package com.alura.challenge.service

import com.alura.challenge.model.CategoriaModel
import com.alura.challenge.repository.CategoriaRepository
import org.springframework.stereotype.Service

@Service
class CategoriaService(
    val contaUsuarioRepository: CategoriaRepository
) {

    fun getAll(): List<CategoriaModel> {
        return contaUsuarioRepository.findAll()
    }

    fun findById(id: Int): CategoriaModel {
        return contaUsuarioRepository.findById(id).orElseThrow()
    }

    fun create(conta: CategoriaModel) {
        contaUsuarioRepository.save(conta)
    }

}