package casadocodigo.casadocodigo.dtos

import casadocodigo.casadocodigo.entities.Categoria
import javax.validation.constraints.NotBlank

class CategoriaDTO (


    @NotBlank
    val nomeCategoria: String
)

{
    fun toModel(): Categoria{return Categoria(null, this.nomeCategoria)}
}