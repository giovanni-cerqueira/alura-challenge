package com.alura.challenge.controller

import com.alura.challenge.controller.request.PostCategoriaRequest
import com.alura.challenge.controller.request.PutCategoriaRequest
import com.alura.challenge.controller.request.PutDespesasRequest
import com.alura.challenge.extension.toCategoriaModel
import com.alura.challenge.extension.toDespesasModel
import com.alura.challenge.model.CategoriaModel
import com.alura.challenge.service.CategoriaService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete (@PathVariable id: Int){
        categoriaService.delete(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update (@PathVariable id: Int, @RequestBody @Valid categoria: PutCategoriaRequest) {
        val categoriaSalva = categoriaService.findById(id)
        categoriaService.update(categoria.toCategoriaModel(categoriaSalva))
    }
}