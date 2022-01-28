package com.alura.challenge.controller

import com.alura.challenge.controller.request.PostReceitasRequest
import com.alura.challenge.controller.request.PutReceitasRequest
import com.alura.challenge.extension.toReceitasModel
import com.alura.challenge.service.ReceitasService
import com.alura.challenge.extension.toResponse
import com.alura.challenge.model.ReceitasModel
import com.alura.challenge.repository.ReceitasRepository
import com.alura.challenge.response.ReceitasResponse
import com.alura.challenge.service.CategoriaService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("receitas")
class ReceitasController(
    val receitasService: ReceitasService
) {

    @GetMapping
    fun getAll(@RequestParam descricao: String?): List<ReceitasResponse> {
        return receitasService.getAll(descricao).map { it.toResponse() }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid request: PostReceitasRequest) {
        receitasService.create(request.toReceitasModel())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): ReceitasResponse { //ponto de atenção
        return receitasService.findById(id).toResponse()
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        receitasService.delete(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody @Valid receitas: PutReceitasRequest) {
        val receitaSalva = receitasService.findById(id)
        receitasService.update(receitas.toReceitasModel(receitaSalva))
    }






}