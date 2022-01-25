package com.alura.challenge.model

import javax.persistence.*

@Entity(name = "conta_usuario")
data class ContaUsuarioModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var nome: String,

    @Column
    var email: String,

    @Column
    var senha: String
) {
}