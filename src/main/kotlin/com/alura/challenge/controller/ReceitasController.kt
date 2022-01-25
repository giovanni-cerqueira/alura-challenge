package com.alura.challenge.controller

import com.alura.challenge.controller.request.PostReceitasRequest
import com.alura.challenge.controller.request.PutReceitasRequest
import com.alura.challenge.extension.toReceitasModel
import com.alura.challenge.service.ReceitasService
import com.alura.challenge.extension.toResponse
import com.alura.challenge.model.ReceitasModel
import com.alura.challenge.repository.ReceitasRepository
import com.alura.challenge.response.ReceitasResponse
import com.alura.challenge.service.ContaUsuarioService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("receitas")
class ReceitasController(
    val receitasRepository: ReceitasRepository,
    val receitasService: ReceitasService,
    val contaUsuarioService: ContaUsuarioService
) {

    @GetMapping
    fun getAll(): List<ReceitasModel> {
        return receitasService.getAll()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid request: PostReceitasRequest) {
        val receita = contaUsuarioService.findById(request.contaId)
        receitasService.create(request.toReceitasModel(receita))
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