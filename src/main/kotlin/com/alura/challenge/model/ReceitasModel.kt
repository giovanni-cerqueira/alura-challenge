package com.alura.challenge.model

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*
import javax.persistence.*

@Entity(name = "receitas")
class ReceitasModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var descricao: String,

    @Column
    var valor: Float,

    @Column
    @JsonFormat(pattern="dd-MM-yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    var data: Date = java.sql.Date(System.currentTimeMillis())

) {
}