package com.alura.challenge.controller.request


import com.alura.challenge.validation.despesas.DescriptionDespesasAvailable
import com.fasterxml.jackson.annotation.JsonAlias
import java.util.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class PostDespesasRequest (

    @field: NotEmpty(message = "Descrição inválida.")
    @DescriptionDespesasAvailable
    var descricao: String,

    @field: NotNull(message = "Valor inválido.")
    var valor: Float,

    @field: NotNull(message = "Data inválido.")
    var data: Date = java.sql.Date(System.currentTimeMillis()),

    @JsonAlias("conta_id")
    var contaId: Int
) {
}