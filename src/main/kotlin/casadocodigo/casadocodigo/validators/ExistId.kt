package casadocodigo.casadocodigo.validators

import casadocodigo.casadocodigo.validators.ExistsIdValidator
import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Documented
@Constraint(validatedBy = [ExistsIdValidator::class])
@Target(AnnotationTarget.FIELD)
@Retention(
    RetentionPolicy.RUNTIME
)

annotation class ExistsId(

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