package casadocodigo.casadocodigo.dtos

import casadocodigo.casadocodigo.entities.Autor
import javax.validation.constraints.NotBlank

data class AutorDTO(

    val nomeAutor: String,


    @NotBlank
    @UniqueValue(domainClass = Autor.class, fieldName = "emailAutor")
    val emailAutor: String,
    val descAutor: String

)