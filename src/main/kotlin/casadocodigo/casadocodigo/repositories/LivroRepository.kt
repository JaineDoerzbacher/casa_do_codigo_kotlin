package casadocodigo.casadocodigo.repositories

import casadocodigo.casadocodigo.entities.Livro
import org.springframework.data.jpa.repository.JpaRepository

interface LivroRepository: JpaRepository<Livro, Long> {

    fun findByTitulo(titulo: String?): List<Livro?>?
}