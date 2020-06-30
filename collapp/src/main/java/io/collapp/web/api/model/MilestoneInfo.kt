
package io.collapp.web.api.model

import io.collapp.model.ColumnDefinition
import io.collapp.model.LabelListValue

class MilestoneInfo
@java.beans.ConstructorProperties("labelListValue", "cardsCountByStatus") constructor(
        val labelListValue: LabelListValue, val cardsCountByStatus: Map<ColumnDefinition, Long>)
