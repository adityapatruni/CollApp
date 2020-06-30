
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column
import java.util.*

open class FileDataLight(@Column("CARD_DATA_CARD_ID_FK") val cardId: Int,
                         @Column("CARD_DATA_ID") val cardDataId: Int,
                         @Column("CARD_DATA_REFERENCE_ID") val referenceId: Int?,
                         @Column("CARD_DATA_CONTENT") val digest: String,
                         @Column("SIZE") val size: Int,
                         @Column("DISPLAYED_NAME") val name: String,
                         @Column("CONTENT_TYPE") val contentType: String,
                         @Column("EVENT_USER_ID_FK") val userId: Int,
                         @Column("EVENT_TIME") val time: Date)
