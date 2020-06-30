
package io.collapp.web.api.model

import io.collapp.model.BoardColumnDefinition
import io.collapp.model.ColumnDefinition

open class TaskStatistics(tasks: Map<ColumnDefinition, Int>,
                          columnDefinitions: Map<ColumnDefinition, BoardColumnDefinition>) {

    val openTaskColor: Int
    val closedTaskColor: Int
    val backlogTaskColor: Int
    val deferredTaskColor: Int

    val openTaskCount: Int?
    val closedTaskCount: Int?
    val backlogTaskCount: Int?
    val deferredTaskCount: Int?

    init {

        this.openTaskColor = columnDefinitions[ColumnDefinition.OPEN]!!.color
        this.closedTaskColor = columnDefinitions[ColumnDefinition.CLOSED]!!.color
        this.backlogTaskColor = columnDefinitions[ColumnDefinition.BACKLOG]!!.color
        this.deferredTaskColor = columnDefinitions[ColumnDefinition.DEFERRED]!!.color

        this.openTaskCount = tasks[ColumnDefinition.OPEN]
        this.closedTaskCount = tasks[ColumnDefinition.CLOSED]
        this.backlogTaskCount = tasks[ColumnDefinition.BACKLOG]
        this.deferredTaskCount = tasks[ColumnDefinition.DEFERRED]
    }
}
