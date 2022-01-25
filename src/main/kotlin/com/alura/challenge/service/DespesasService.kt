package com.alura.challenge.service

import com.alura.challenge.model.DespesasModel
import com.alura.challenge.repository.DespesasRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class DespesasService(
    val despesasRepository: DespesasRepository
) {

    fun getAll(): List<DespesasModel> {
        return despesasRepository.findAll().toList()
    }

    fun create(despesas: DespesasModel) {
        despesasRepository.save(despesas)
    }

    fun findById(id: Int): DespesasModel {
        return despesasRepository.findById(id).orElseThrow()
    }

    fun delete(id: Int) {
        despesasRepository.deleteById(id)
    }

    fun update(despesas: DespesasModel) {
        if (!despesasRepository.existsById(despesas.id!!)) {
            throw Exception()
        }
        despesasRepository.save(despesas)
    }

    fun checkDescricao(descricao: String): Boolean {
        var data: LocalDateTime = LocalDateTime.now()
        var despesas = despesasRepository.existsByDescricao(descricao)
        if(despesas != true && data.month.equals(despesas)){
            return despesasRepository.existsByDescricao(descricao)
        }
        return !despesasRepository.existsByDescricao(descricao)
    }
}