package com.alura.challenge.model

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.lang.Nullable
import java.util.*
import javax.persistence.*

var categoriaNula: CategoriaModel? = CategoriaModel(8, "Outras")

@Entity(name = "despesas")
data class DespesasModel(

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
    var data: Date = java.sql.Date(System.currentTimeMillis()),

    @ManyToOne
    @JsonAlias("categoria_id")
    @Nullable
    var categoriaId: CategoriaModel? = CategoriaModel(8, "Outras")
) {

}