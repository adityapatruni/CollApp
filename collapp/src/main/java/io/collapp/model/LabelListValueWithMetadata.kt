
package io.collapp.model

import java.util.*

open class LabelListValueWithMetadata(llv: LabelListValue, metadata: Map<String, String>?) : LabelListValue(llv.id, llv.cardLabelId, llv.order, llv.value) {

    val metadata: Map<String, String>

    init {
        this.metadata = if (metadata == null) emptyMap<String, String>() else TreeMap(metadata)
    }
}
