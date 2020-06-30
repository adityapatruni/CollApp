
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column

class CalendarInfo(@Column("USER_CALENDAR_TOKEN") val token: String,
                   @Column("USER_CALENDAR_DISABLE_FEED") val disabled: Boolean)
