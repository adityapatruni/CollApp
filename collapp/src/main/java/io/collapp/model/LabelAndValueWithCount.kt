
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column
import io.collapp.model.CardLabel.LabelType

class LabelAndValueWithCount(@Column("CARD_LABEL_ID") val labelId: Int, @Column("CARD_LABEL_NAME") val labelName: String,
                             @Column("CARD_LABEL_COLOR") val labelColor: Int, @Column("CARD_LABEL_VALUE_TYPE") labelValueType: LabelType,
                             @Column("CARD_LABEL_VALUE_LIST_VALUE_FK") labelValueList: Int?, @Column("LABEL_COUNT") val count: Long?) {
    val labelValueType: LabelType
    val value: CardLabelValue.LabelValue

    init {
        var labelValueType = labelValueType
        if (labelValueType != LabelType.NULL && labelValueType != LabelType.LIST) {
            labelValueType = LabelType.NULL
        }
        this.labelValueType = labelValueType
        this.value = CardLabelValue.LabelValue(null, null, null, null, null, labelValueList)
    }
}
