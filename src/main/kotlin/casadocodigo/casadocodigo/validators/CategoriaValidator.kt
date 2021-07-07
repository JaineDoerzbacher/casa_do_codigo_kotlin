package casadocodigo.casadocodigo.validators

import casadocodigo.casadocodigo.dtos.CategoriaDTO
import casadocodigo.casadocodigo.entities.Categoria
import casadocodigo.casadocodigo.repositories.CategoriaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.Errors
import org.springframework.validation.ValidationUtils
import org.springframework.validation.Validator

class CategoriaValidator: Validator {

    @Autowired
    lateinit var categoriaRepository: CategoriaRepository

    override fun supports(aClass: Class<*>): Boolean {

        return CategoriaDTO::class.java == aClass
    }

    override fun validate(o: Any, errors: Errors) {

        ValidationUtils.rejectIfEmpty(errors, "nomeCategoria", "O nome da categoria não pode estar vazio")

        val categoriaDTO = o as CategoriaDTO


        val listaCategorias: List<Categoria?> = categoriaRepository.findByNome(categoriaDTO.nomeCategoria)

        if (listaCategorias.isNotEmpty()) {
            errors.rejectValue("nomeCategoria", "Essa categoria já existe!")
        }

    }
}