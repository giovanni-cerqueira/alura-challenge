package com.alura.challenge.validation.categorias

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [CategoriaAvailableValidator::class])
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class CategoriaAvailable(
    val message: String = "Categoria já cadastrada",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []

)
