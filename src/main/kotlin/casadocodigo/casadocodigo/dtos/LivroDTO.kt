package casadocodigo.casadocodigo.dtos

import casadocodigo.casadocodigo.entities.Autor
import casadocodigo.casadocodigo.entities.Categoria
import casadocodigo.casadocodigo.entities.Livro
import casadocodigo.casadocodigo.validators.ExistsId
import com.fasterxml.jackson.annotation.JsonFormat
import java.math.BigDecimal
import java.time.LocalDate
import java.util.function.Function
import java.util.stream.Collectors
import javax.validation.constraints.Future
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class LivroDTO(

    @NotBlank
    val titulo: String,

    @NotBlank
    @Size(max = 500)
    val resumo: String,

    @NotBlank
    val sumario: String,

    @NotBlank
    @Size(min = 20)
    val preco: BigDecimal,

    @NotBlank
    @Size(min = 100)
    val numeroPaginas: Int,

    @NotBlank
    val isbn: String,

    @Future
    @JsonFormat(pattern = "dd/mm/yyyy", shape = JsonFormat.Shape.STRING)
    @NotBlank
    val data_publicacao: LocalDate,

    @NotNull
    @ExistsId(domainClass = Categoria::class, fieldName = "id")
    val idCategoria: Long,

    @NotNull
    @ExistsId(domainClass = Autor::class, fieldName = "emailAutor")
    val emailAutor: String
)

{

    fun toModel(): Livro { return Livro(
        null,
        this.titulo,
        this.resumo,
        this.sumario,
        this.preco,
        this.numeroPaginas,
        this.isbn,
        this.data_publicacao,
        null,
        this.emailAutor )
    }


    fun converter(livros: List<Livro>): List<LivroDTO> {

        return livros.stream().map(Function { livro: Livro ->
            LivroDTO(livro.titulo, livro.resumo, livro.sumario, livro.preco, livro.numeroPaginas,
            livro.isbn, livro.data_publicacao, livro.categoria.id?) }).collect(Collectors.toList())
    }

}