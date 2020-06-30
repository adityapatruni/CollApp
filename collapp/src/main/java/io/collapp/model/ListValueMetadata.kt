
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column
import org.apache.commons.lang3.builder.EqualsBuilder
import org.apache.commons.lang3.builder.HashCodeBuilder

class ListValueMetadata(@Column("LVM_LABEL_LIST_VALUE_ID_FK") val labelListValueId: Int,
                        @Column("LVM_KEY") val key: String, @Column("LVM_VALUE") val value: String) {

    override fun equals(o: Any?): Boolean {
        if (o === this)
            return true
        if (o !is ListValueMetadata)
            return false
        return EqualsBuilder().append(labelListValueId, o.labelListValueId).append(key, o.key).append(value, o.value).isEquals();
    }

    override fun hashCode(): Int {
        return HashCodeBuilder().append(labelListValueId).append(key).append(value).toHashCode();
    }

    protected fun canEqual(other: Any): Boolean {
        return other is ListValueMetadata
    }
}
