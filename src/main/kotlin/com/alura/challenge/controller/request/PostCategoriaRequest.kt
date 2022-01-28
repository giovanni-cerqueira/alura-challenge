package com.alura.challenge.controller.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class PostCategoriaRequest(

    @field:NotEmpty
    var titulo: String
) {
}