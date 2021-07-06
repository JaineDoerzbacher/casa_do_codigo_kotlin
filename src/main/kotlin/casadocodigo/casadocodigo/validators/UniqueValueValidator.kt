package casadocodigo.casadocodigo.validators

import org.springframework.util.Assert
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import kotlin.reflect.KClass

class UniqueValueValidator : ConstraintValidator<UniqueValue, Any> {



    private var domainAttrribute: String? = null
    private lateinit var klass: KClass<*>

    @PersistenceContext
    private val manager: EntityManager? = null

    override fun initialize(params: UniqueValue) {
        domainAttrribute = params.fieldName
        klass = params.domainClass
    }

    override fun isValid(value: Any?, context: ConstraintValidatorContext?): Boolean {
        val query = manager!!.createQuery("select 1 from " + klass.simpleName + "where " + domainAttrribute + "=:value")
        query.setParameter("value", value)
        val list = query.resultList
        Assert.isTrue(list.size <= 1, "Foi encontrado mais de um " + klass + "com o atributo igual!")
        return list.isEmpty()
    }
}