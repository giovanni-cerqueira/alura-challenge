package com.alura.challenge.response

data class ContasResponse(

    var id: Int? = null,

    var saldo: Float,

    var nome: String,

    var email: String,

    var senha: String
) {
}