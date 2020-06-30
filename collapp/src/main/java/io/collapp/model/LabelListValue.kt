
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column
import org.apache.commons.lang3.builder.EqualsBuilder
import org.apache.commons.lang3.builder.HashCodeBuilder

open class LabelListValue(@Column("CARD_LABEL_LIST_VALUE_ID") val id: Int, @Column("CARD_LABEL_ID_FK") val cardLabelId: Int,
                          @Column("CARD_LABEL_LIST_VALUE_ORDER") val order: Int, @Column("CARD_LABEL_LIST_VALUE") val value: String) {


    fun newValue(newValue: String): LabelListValue {
        return LabelListValue(id, cardLabelId, order, newValue)
    }

    override fun equals(o: Any?): Boolean {
        if (o === this)
            return true
        if (o !is LabelListValue)
            return false
        return EqualsBuilder().append(id, o.id).append(cardLabelId, o.cardLabelId).append(order, o.order).append(value, o.value).isEquals();
    }

    override fun hashCode(): Int {
        return HashCodeBuilder().append(id).append(cardLabelId).append(order).append(value).toHashCode();
    }

    protected fun canEqual(other: Any): Boolean {
        return other is LabelListValue
    }
}
