package com.alura.challenge.validation.receitas

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [DescriptionReceitasAvailableValidator::class])
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class DescriptionReceitasAvailable(
    val message: String = "Descrição já cadastrada",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []

)
