package casadocodigo.casadocodigo.repositories

import casadocodigo.casadocodigo.entities.Autor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface AutorRepository : JpaRepository<Autor, Long> {


    @Query("select a from Autor a where a.emailAutor = :email")
    fun findByEmail(@Param("email") email: String): List<Autor>

}