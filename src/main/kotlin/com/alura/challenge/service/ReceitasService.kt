package com.alura.challenge.service


import com.alura.challenge.model.ReceitasModel
import com.alura.challenge.repository.ReceitasRepository


import org.springframework.stereotype.Service

import java.lang.Exception
import java.time.LocalDateTime

@Service
class ReceitasService(
   val receitasRepository: ReceitasRepository
) {

    fun getAll(): List<ReceitasModel> {
        return receitasRepository.findAll()
    }

    fun create(receitas: ReceitasModel) {
        receitasRepository.save(receitas)
    }

    fun findById(id: Int): ReceitasModel {
        return receitasRepository.findById(id).orElseThrow()
    }

    fun delete(id: Int) {
        receitasRepository.deleteById(id)
    }

    fun update(receitas: ReceitasModel) {
        if(!receitasRepository.existsById(receitas.id!!)){
            throw Exception()
        }

        receitasRepository.save(receitas)
    }

    fun checkDescricao(descricao: String): Boolean {
        var data: LocalDateTime = LocalDateTime.now()
        var despesas = receitasRepository.existsByDescricao(descricao)
        if(despesas != true && data.month.equals(despesas)){
            return receitasRepository.existsByDescricao(descricao)
        }
        return !receitasRepository.existsByDescricao(descricao)
    }

}