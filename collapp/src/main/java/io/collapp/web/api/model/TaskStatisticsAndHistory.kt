
package io.collapp.web.api.model

import io.collapp.model.*

class TaskStatisticsAndHistory(tasks: Map<ColumnDefinition, Int>,
                               columnDefinitions: Map<ColumnDefinition, BoardColumnDefinition>,
                               val statusHistory: Map<Long, Map<ColumnDefinition, Long>>,
                               val createdAndClosedCards: Map<Long, Pair<Long, Long>>,
                               val activeUsers: Int?,
                               val averageUsersPerCard: Double,
                               val averageCardsPerUser: Double,
                               val cardsByLabel: List<LabelAndValueWithCount>,
                               val mostActiveCard: CardFull?) : TaskStatistics(tasks, columnDefinitions)
