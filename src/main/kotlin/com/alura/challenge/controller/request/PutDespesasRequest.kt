package com.alura.challenge.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import java.util.*
import javax.persistence.Temporal
import javax.persistence.TemporalType
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class PutDespesasRequest(

    @field: NotEmpty(message = "Descrição inválida.")
    var descricao: String,

    @field: NotNull(message = "Valor inválido.")
    var valor: Float,

    @field: NotNull(message = "Data inválido.")
    @Temporal(TemporalType.TIMESTAMP)
    var data: Date = java.sql.Date(System.currentTimeMillis()),

    @JsonAlias("categoria_id")
    var categoriaId: Int

) {
}