package com.alura.challenge.model

import javax.persistence.*

@Entity(name = "categoria")
data class CategoriaModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var titulo: String
) {

}