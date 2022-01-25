package com.alura.challenge.validation.receitas

import com.alura.challenge.repository.ReceitasRepository
import com.alura.challenge.service.DespesasService
import com.alura.challenge.service.ReceitasService
import java.time.LocalDateTime
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class DescriptionReceitasAvailableValidator(var receitasService: ReceitasService): ConstraintValidator<DescriptionReceitasAvailable, String> {

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if(value.isNullOrEmpty()){
            return false
        }
        return receitasService.checkDescricao(value)
    }

}
