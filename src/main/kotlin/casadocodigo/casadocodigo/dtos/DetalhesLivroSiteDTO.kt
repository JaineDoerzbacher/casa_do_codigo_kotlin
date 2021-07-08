package casadocodigo.casadocodigo.dtos

import casadocodigo.casadocodigo.entities.Autor
import casadocodigo.casadocodigo.entities.Livro
import java.math.BigDecimal

class DetalhesLivroSiteDTO (


     var autor: Autor,
     var titulo: String,
     var isbn: String,
     var numeroPaginas: Int,
     var preco: BigDecimal,
     var resumo: String? = null,
     var sumario: String? = null
)
{
    constructor(livro: Livro) :
            this(
                autor = livro.autor!!,
                titulo = livro.titulo,
                isbn = livro.isbn, numeroPaginas = livro.numeroPaginas,
                preco = livro.preco
            )
}