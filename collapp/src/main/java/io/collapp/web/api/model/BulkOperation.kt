package io.collapp.web.api.model

import io.collapp.model.CardLabelValue

class BulkOperation(
    val labelId: Int?,
    val value: CardLabelValue.LabelValue?,
    val cardIds: List<Int>
)
