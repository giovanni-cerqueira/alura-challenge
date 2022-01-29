package com.alura.challenge.service

import com.alura.challenge.model.CategoriaModel
import com.alura.challenge.repository.CategoriaRepository
import org.springframework.stereotype.Service

@Service
class CategoriaService(
    val categoriaRepository: CategoriaRepository
) {

    fun getAll(): List<CategoriaModel> {
        return categoriaRepository.findAll()
    }

    fun findById(id: Int): CategoriaModel {
        return categoriaRepository.findById(id).orElseThrow()
    }

    fun create(conta: CategoriaModel) {
        categoriaRepository.save(conta)
    }

    fun delete(id: Int) {
        categoriaRepository.deleteById(id)
    }

    fun update(categoria: CategoriaModel) {
        if (!categoriaRepository.existsById(categoria.id!!)) {
            throw Exception()
        }
        categoriaRepository.save(categoria)
    }

    fun checkCategoria(titulo: String): Boolean{
        return !categoriaRepository.existsByTitulo(titulo)
    }

}