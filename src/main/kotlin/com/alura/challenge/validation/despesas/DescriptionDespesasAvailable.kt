package com.alura.challenge.validation.despesas

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [DescriptionDespesasAvailableValidator::class])
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class DescriptionDespesasAvailable(
    val message: String = "Descrição já cadastrada",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []

)
