package casadocodigo.casadocodigo.repositories

import casadocodigo.casadocodigo.entities.Autor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AutorRepository : JpaRepository<Autor, Long> {
}