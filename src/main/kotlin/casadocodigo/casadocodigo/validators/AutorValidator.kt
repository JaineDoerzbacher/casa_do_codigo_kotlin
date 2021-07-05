package casadocodigo.casadocodigo.validators

import casadocodigo.casadocodigo.repositories.AutorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.Errors
import org.springframework.validation.Validator


class AutorValidator: Validator {


    @Autowired
    lateinit var autorRepository: AutorRepository


    override fun supports(clazz: Class<*>): Boolean {
        TODO("Not yet implemented")
    }

    override fun validate(target: Any, errors: Errors) {
        TODO("Not yet implemented")
    }

}