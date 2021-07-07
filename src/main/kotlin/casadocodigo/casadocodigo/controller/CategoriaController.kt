package casadocodigo.casadocodigo.controller

import casadocodigo.casadocodigo.dtos.CategoriaDTO
import casadocodigo.casadocodigo.entities.Categoria
import casadocodigo.casadocodigo.repositories.CategoriaRepository
import casadocodigo.casadocodigo.validators.CategoriaValidator
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping(value = ["/categorias"])
class CategoriaController {


    private lateinit var categoriaRepository: CategoriaRepository


    fun CategoriaRepository(categoriaRepository: CategoriaRepository) {
        this.categoriaRepository = categoriaRepository
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun cadastraCategoria(@RequestBody @Validated(CategoriaValidator::class) request: @Valid CategoriaDTO) {

        val categoria: Categoria = request.toModel()

        categoriaRepository.save(categoria)
    }

}