package com.alura.challenge.response

import com.alura.challenge.model.ContaUsuarioModel
import java.util.*

class DespesasResponse(
    var id: Int? = null,

    var descricao: String,

    var valor: Float,

    var data: Date,

    var contaId: ContaUsuarioModel? = null
) {
}