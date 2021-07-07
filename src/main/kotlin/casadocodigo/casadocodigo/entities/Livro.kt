package casadocodigo.casadocodigo.entities

import com.fasterxml.jackson.annotation.JsonFormat
import org.hibernate.validator.constraints.Length
import org.springframework.data.annotation.Id
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.Future
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull


@Entity
@Table(name = "TB_LIVRO")
data class Livro(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @NotNull
    @NotBlank
    @Column(name = "TITULO")
    val titulo: String,

    @NotNull @NotBlank
    @Column(name = "RESUMO")
    val resumo: String,

    @NotNull @NotBlank
    @Column(name = "SUMARIO")
    val sumario: String,

    @NotNull @NotBlank
    @Column(name = "PRECO")
    @Length(min = 20)
    val preco: BigDecimal,

    @NotNull @NotBlank
    @Column(name = "NUMERO_PAGINAS")
    val numeroPaginas: Int,

    @NotNull @NotBlank
    @Column(name = "ISBN")
    val isbn: String,

    @Future
    @JsonFormat(pattern = "dd/mm/yyyy", shape = JsonFormat.Shape.STRING)
    @NotNull @NotBlank
    @Column(name = "DATA")
    val data_publicacao: LocalDate,

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA")
    @NotNull
    val categoria: Categoria?,

    @ManyToOne
    @JoinColumn(name = "ID_AUTOR")
    @NotNull
    val autor: String


)
