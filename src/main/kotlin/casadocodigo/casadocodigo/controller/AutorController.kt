package casadocodigo.casadocodigo.controller

import casadocodigo.casadocodigo.dtos.AutorDTO
import casadocodigo.casadocodigo.entities.Autor
import casadocodigo.casadocodigo.repositories.AutorRepository
import casadocodigo.casadocodigo.validators.AutorValidator
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping(value = ["/autores"])
class AutorController {

    private lateinit var autorRepository: AutorRepository


    fun AutorController(autorRepository: AutorRepository) {
        this.autorRepository = autorRepository
    }


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun cadastraAutor(@RequestBody @Validated(AutorValidator::class) request: @Valid AutorDTO) {

        val autor: Autor = request.toModel()

        autorRepository.save(autor)
    }
}