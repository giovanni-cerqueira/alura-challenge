package com.alura.challenge.extension

import com.alura.challenge.controller.request.*
import com.alura.challenge.model.ContaUsuarioModel
import com.alura.challenge.model.DespesasModel
import com.alura.challenge.model.ReceitasModel
import com.alura.challenge.response.DespesasResponse
import com.alura.challenge.response.ReceitasResponse


fun PostContasRequest.toContaUsuarioModel(): ContaUsuarioModel {
    return ContaUsuarioModel(
        nome = this.nome,
        email = this.email,
        senha = this.senha
    )
}

fun PostReceitasRequest.toReceitasModel(conta: ContaUsuarioModel): ReceitasModel {
    return ReceitasModel(
        descricao = this.descricao,
        valor = this.valor,
        data = this.data,
        contaId = conta
    )
}

fun PutReceitasRequest.toReceitasModel(previousValue: ReceitasModel): ReceitasModel {
    return ReceitasModel(
        id = previousValue.id,
        descricao = this.descricao,
        valor = this.valor,
        data = this.data,
        contaId = previousValue.contaId
    )
}

fun ReceitasModel.toResponse(): ReceitasResponse {
    return ReceitasResponse(
        id = this.id,
        descricao = this.descricao,
        valor = this.valor,
        data = this.data,
        contaId = this.contaId
    )
}

fun PostDespesasRequest.toDespesasModel(conta: ContaUsuarioModel): DespesasModel {
    return DespesasModel(
        descricao = this.descricao,
        valor = this.valor,
        data = this.data,
        contaId = conta
    )
}

fun PutDespesasRequest.toDespesasModel(previousValue: DespesasModel): DespesasModel {
    return DespesasModel(
        id = previousValue.id,
        descricao = this.descricao,
        valor = this.valor,
        data = this.data,
        contaId = previousValue.contaId
    )
}

fun DespesasModel.toResponse(): DespesasResponse {
    return DespesasResponse(
        descricao = this.descricao,
        valor = this.valor,
        data = this.data
    )
}