package casadocodigo.casadocodigo.validators

import casadocodigo.casadocodigo.dtos.AutorDTO
import casadocodigo.casadocodigo.entities.Autor
import casadocodigo.casadocodigo.repositories.AutorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.Errors
import org.springframework.validation.ValidationUtils
import org.springframework.validation.Validator


class AutorValidator: Validator {


    @Autowired
    lateinit var autorRepository: AutorRepository

    //Especifica qual classe será validada
    override fun supports(aClass: Class<*>): Boolean {
        return AutorDTO::class.java == aClass
    }


    override fun validate(o: Any, errors: Errors) {

        ValidationUtils.rejectIfEmpty(errors, "nomeAutor", "O nome do autor não pode estar vazio")
        ValidationUtils.rejectIfEmpty(errors, "emailAutor", "O e-mail do autor não pode estar vazio")
        ValidationUtils.rejectIfEmpty(errors, "descAutor", "A descrição do autor não pode estar vazia")


        val autorDTO = o as AutorDTO

        val listaAutores: List<Autor?> = autorRepository.findByEmail(autorDTO.emailAutor)

        if (listaAutores.isNotEmpty()) {
            errors.rejectValue("emailAutor", "O e-mail já existe!")
        }
    }

}