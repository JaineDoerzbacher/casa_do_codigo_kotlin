package casadocodigo.casadocodigo.controller

import casadocodigo.casadocodigo.dtos.DetalhesLivroSiteDTO
import casadocodigo.casadocodigo.entities.Livro
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

class DetalheSiteAutorController {

    @PersistenceContext
    private lateinit var  manager: EntityManager

    @GetMapping(value = ["/produtos/{id}"])
    fun getMethodName(@PathVariable("id") id: Long): ResponseEntity<*> {

        val buscaLivro = manager.find(Livro::class.java, id) ?:
        return ResponseEntity.notFound().build<Any>()

        val detalhesLivroSiteDTO = DetalhesLivroSiteDTO(buscaLivro)
        return ResponseEntity.ok<Any>(detalhesLivroSiteDTO)
    }
}