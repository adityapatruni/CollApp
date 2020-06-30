
package io.collapp.web.api.model

import io.collapp.model.ColumnDefinition
import io.collapp.model.Pair
import io.collapp.model.SearchResults

class MilestoneDetail
@java.beans.ConstructorProperties("cardsCountByStatus", "statusColors", "cards", "assignedAndClosedCards")
constructor(val cardsCountByStatus: Map<ColumnDefinition, Long>,
            val statusColors: Map<ColumnDefinition, Int>,
            val cards: SearchResults?,
            val assignedAndClosedCards: Map<Long, Pair<Long, Long>>)
