
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column
import org.apache.commons.lang3.time.DateUtils
import java.util.*

class EventsCount(@Column("EVENT_DATE") date: Date, @Column("EVENT_COUNT") val count: Long) {

    val date: Long

    init {
        this.date = DateUtils.truncate(date, Calendar.DATE).time
    }
}
