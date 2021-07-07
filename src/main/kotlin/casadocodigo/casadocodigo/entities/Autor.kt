package casadocodigo.casadocodigo.entities

import org.springframework.data.annotation.Id
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name = "TB_AUTOR")
data class Autor (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @NotNull
    @NotBlank
    @Column(name = "NOME_AUTOR")
    val nomeAutor: String,

    @NotNull @NotBlank
    @Column(name = "EMAIL_AUTOR")
    val emailAutor: String,

    @NotNull @NotBlank
    @Column(name = "DESC_AUTOR", length = 400)
    val descAutor: String,

    @Column(name = "LOCAL")
    val local: LocalDateTime = LocalDateTime.now()

)