package casadocodigo.casadocodigo.controller

import casadocodigo.casadocodigo.dtos.LivroDTO
import casadocodigo.casadocodigo.entities.Livro
import casadocodigo.casadocodigo.repositories.LivroRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.validation.Valid

class LivroController {

    @PersistenceContext
    lateinit var manager: EntityManager

    private lateinit var livroRepository: LivroRepository

    fun LivroRepository(livroRepository: LivroRepository) {
        this.livroRepository = livroRepository
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun cadastraLivro(@RequestBody request: @Valid LivroDTO) {

        val livro: Livro = request.toModel()

        livroRepository.save(livro)
    }

    @GetMapping
    fun lista(titulo: String?): List<LivroDTO?>? {

        val livro  =  if (titulo == null) {

            livroRepository.findAll()

        } else {

            livroRepository.findByTitulo(titulo)
        }
        return LivroDTO.converter(livro)
    }

}