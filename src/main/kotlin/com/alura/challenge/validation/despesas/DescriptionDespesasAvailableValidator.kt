package com.alura.challenge.validation.despesas

import com.alura.challenge.service.DespesasService
import com.alura.challenge.service.ReceitasService
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class DescriptionDespesasAvailableValidator(var despesasService: DespesasService): ConstraintValidator<DescriptionDespesasAvailable, String> {

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if(value.isNullOrEmpty()){
            return false
        }

        return despesasService.checkDescricao(value)
    }

}
