package casadocodigo.casadocodigo.entities

import org.springframework.data.annotation.Id
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class Categoria(


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,


    @NotNull
    @NotBlank
    @Column(name = "NOME_CATEGORIA")
    val nomeCategoria: String
)
