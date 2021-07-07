package casadocodigo.casadocodigo.repositories

import casadocodigo.casadocodigo.entities.Categoria
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface CategoriaRepository: JpaRepository<Categoria, Long>{

    @Query("select a from Categoria a where a.nomeCategoria = :nome")
    fun findByNome(@Param("nome") nome: String): List<Categoria>
}