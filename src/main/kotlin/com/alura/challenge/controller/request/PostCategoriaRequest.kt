package com.alura.challenge.controller.request

import com.alura.challenge.validation.categorias.CategoriaAvailable
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class PostCategoriaRequest(

    @field:NotEmpty(message = "Categoria inválida.")
    @CategoriaAvailable
    var titulo: String
) {
}