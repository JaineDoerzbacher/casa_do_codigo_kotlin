package casadocodigo.casadocodigo.dtos

import casadocodigo.casadocodigo.entities.Autor
import casadocodigo.casadocodigo.validators.UniqueValue
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class AutorDTO(

    @NotBlank
    val nomeAutor: String,

    @NotBlank
    @UniqueValue(domainClass = Autor::class, fieldName = "emailAutor")
    val emailAutor: String,

    @NotBlank
    @Size(max = 400)
    val descAutor: String



){
    fun toModel(): Autor{ return Autor(null, this.nomeAutor, this.emailAutor, this.descAutor)}
}