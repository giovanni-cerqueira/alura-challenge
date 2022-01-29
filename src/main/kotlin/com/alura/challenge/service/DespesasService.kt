package com.alura.challenge.service

import com.alura.challenge.model.CategoriaModel
import com.alura.challenge.model.DespesasModel
import com.alura.challenge.repository.CategoriaRepository
import com.alura.challenge.repository.DespesasRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class DespesasService(
    val despesasRepository: DespesasRepository
) {

    fun getAll(descricao: String?): List<DespesasModel> {
        descricao?.let{
            return despesasRepository.findByDescricaoContaining(it)
        }
        return despesasRepository.findAll()
    }

//    val despesas = mutableListOf<DespesasModel>()
//    fun getAll(descricao: String?): List<DespesasModel> {
//        descricao?.let{
//            return despesas.filter { it.descricao.contains(descricao, true) }
//        }
//        return despesas
//    }

    fun create(despesas: DespesasModel) {
//        if(despesas.categoriaId == null){
//            categoriaRepository.findByDescricaoIgnoreCase("Outras")
//        }
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

//    fun checkSeCategoriaEstaNulo(despesas: DespesasModel, titulo: String) {
//        if(despesas.categoriaId == null){
//            categoriaRepository.findByDescricaoIgnoreCase("Outras")
//        }
//
//        despesasRepository.save(despesas)
//    }
}