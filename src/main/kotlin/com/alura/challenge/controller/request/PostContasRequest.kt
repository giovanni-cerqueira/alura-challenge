package com.alura.challenge.controller.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class PostContasRequest(

    @field:NotEmpty
    var nome: String,

    @field:Email(message = "E-mail deve ser válido")
    var email: String,

    @field:NotEmpty
    var senha: String,

    @field:NotNull
    var saldo: Float
) {
}