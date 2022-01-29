package com.alura.challenge.controller.request

import javax.validation.constraints.NotEmpty

data class PutCategoriaRequest (

    @field:NotEmpty(message = "Categoria inválida.")
    var titulo: String

    )
{
}