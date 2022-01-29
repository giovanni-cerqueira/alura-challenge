package com.alura.challenge.validation.categorias

import com.alura.challenge.service.CategoriaService
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class CategoriaAvailableValidator(var categoriaService: CategoriaService): ConstraintValidator<CategoriaAvailable, String> {

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if(value.isNullOrEmpty()){
            return false
        }

        return categoriaService.checkCategoria(value)
    }

}
