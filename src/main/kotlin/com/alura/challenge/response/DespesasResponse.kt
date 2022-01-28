package com.alura.challenge.response

import com.alura.challenge.model.CategoriaModel
import java.util.*

data class DespesasResponse(
    var id: Int? = null,

    var descricao: String,

    var valor: Float,

    var data: Date,

    var categoria_id: CategoriaModel? = null
) {
}