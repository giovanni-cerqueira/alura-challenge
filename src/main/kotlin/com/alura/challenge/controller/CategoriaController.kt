package com.alura.challenge.controller

import com.alura.challenge.controller.request.PostCategoriaRequest
import com.alura.challenge.extension.toCategoriaModel
import com.alura.challenge.model.CategoriaModel
import com.alura.challenge.service.CategoriaService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("categoria")
class CategoriaController(
    val categoriaService: CategoriaService
) {

    @GetMapping
    fun getAll(): List<CategoriaModel> {
        return categoriaService.getAll()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody categoria: PostCategoriaRequest) {
        categoriaService.create(categoria.toCategoriaModel())
    }
}