
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column
import io.collapp.model.BoardColumn.BoardColumnLocation
import java.util.*

class StatisticForExport(@Column("BOARD_STATISTICS_TIME") val date: Date,
                         @Column("BOARD_COLUMN_DEFINITION_VALUE") val columnDefinition: ColumnDefinition,
                         @Column("BOARD_STATISTICS_LOCATION") val location: BoardColumnLocation,
                         @Column("BOARD_STATISTICS_COUNT") val count: Long)
