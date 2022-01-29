package com.alura.challenge.controller

import com.alura.challenge.controller.request.PostDespesasRequest
import com.alura.challenge.controller.request.PutDespesasRequest
import com.alura.challenge.extension.toDespesasModel
import com.alura.challenge.extension.toResponse
import com.alura.challenge.model.DespesasModel

import com.alura.challenge.response.DespesasResponse
import com.alura.challenge.service.CategoriaService
import com.alura.challenge.service.DespesasService

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("despesas")
class DespesasController(
    val categoriaService: CategoriaService,
    val despesasService: DespesasService
) {

    @GetMapping
    fun getAll(@RequestParam descricao: String?): List<DespesasResponse>{
        return despesasService.getAll(descricao).map { it.toResponse() }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid request: PostDespesasRequest){
        val despesa = categoriaService.findById(request.categoriaId)
        despesasService.create(request.toDespesasModel(despesa))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): DespesasResponse{ //ponto de atenção
        return despesasService.findById(id).toResponse()
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete (@PathVariable id: Int){
        despesasService.delete(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update (@PathVariable id: Int, @RequestBody @Valid despesas: PutDespesasRequest) {
     val despesaSalva = despesasService.findById(id)
        despesasService.update(despesas.toDespesasModel(despesaSalva))
    }


}