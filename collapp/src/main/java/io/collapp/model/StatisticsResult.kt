
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column
import org.apache.commons.lang3.time.DateUtils
import java.util.*

class StatisticsResult(@Column("TIME") date: Date,
                       @Column("BOARD_COLUMN_DEFINITION_VALUE") val columnDefinition: ColumnDefinition,
                       @Column("STATISTICS_COUNT") val count: Long) {

    val day: Long

    init {
        this.day = DateUtils.truncate(date, Calendar.DATE).time
    }
}
