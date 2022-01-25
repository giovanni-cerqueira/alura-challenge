package com.alura.challenge.controller

import com.alura.challenge.controller.request.PostContasRequest
import com.alura.challenge.extension.toContaUsuarioModel
import com.alura.challenge.model.ContaUsuarioModel
import com.alura.challenge.service.ContaUsuarioService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("conta")
class ContaUsuarioController(
    val contaUsuarioService: ContaUsuarioService
) {

    @GetMapping
    fun getAll(): List<ContaUsuarioModel> {
        return contaUsuarioService.getAll()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody conta: PostContasRequest) {
        contaUsuarioService.create(conta.toContaUsuarioModel())
    }
}