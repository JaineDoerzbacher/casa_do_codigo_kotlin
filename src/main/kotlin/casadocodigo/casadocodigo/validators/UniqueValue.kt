package casadocodigo.casadocodigo.validators

import java.lang.annotation.*
import java.lang.annotation.Retention
import java.lang.annotation.Target
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Documented
@Constraint(validatedBy = [UniqueValueValidator::class])
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

annotation class UniqueValue(


    //Mensagem que será informada, caso não tenha nenhuma, será retornado a string abaixo
    val message: String = "{...}",

    //Grupo das classes que serão validadas com essa anotação
    val groups: Array<KClass<*>> = [],

    //Array dos payloads que estão sendo verificados (o que recebemos como parâmetro)
    val payload: Array<KClass<out Payload>> = [],

    //Atributo da classe que queremos validar
    val fieldName: String,

    //Classe que será validada
    val domainClass: KClass<*>
)
