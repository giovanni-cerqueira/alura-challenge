package com.alura.challenge.extension

import com.alura.challenge.controller.request.*
import com.alura.challenge.model.CategoriaModel
import com.alura.challenge.model.DespesasModel
import com.alura.challenge.model.ReceitasModel
import com.alura.challenge.response.DespesasResponse
import com.alura.challenge.response.ReceitasResponse


fun PostCategoriaRequest.toCategoriaModel(): CategoriaModel {
    return CategoriaModel(
        titulo = this.titulo
    )
}

fun PostReceitasRequest.toReceitasModel(): ReceitasModel {
    return ReceitasModel(
        descricao = this.descricao,
        valor = this.valor,
        data = this.data
    )
}

fun PutReceitasRequest.toReceitasModel(previousValue: ReceitasModel): ReceitasModel {
    return ReceitasModel(
        id = previousValue.id,
        descricao = this.descricao,
        valor = this.valor,
        data = this.data
    )
}



fun PostDespesasRequest.toDespesasModel(categoria: CategoriaModel): DespesasModel {
    return DespesasModel(
        descricao = this.descricao,
        valor = this.valor,
        data = this.data,
        categoriaId = categoria
    )
}

fun PutDespesasRequest.toDespesasModel(previousValue: DespesasModel): DespesasModel {
    return DespesasModel(
        id = previousValue.id,
        descricao = this.descricao,
        valor = this.valor,
        data = this.data,
        categoriaId = previousValue.categoriaId
    )
}

fun DespesasModel.toResponse(): DespesasResponse {
    return DespesasResponse(
        descricao = this.descricao,
        valor = this.valor,
        data = this.data
    )
}

fun ReceitasModel.toResponse(): ReceitasResponse {
    return ReceitasResponse(
        descricao = this.descricao,
        valor = this.valor,
        data = this.data
    )
}