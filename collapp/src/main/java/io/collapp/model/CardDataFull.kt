
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column
import io.collapp.model.Event.EventType
import java.util.*

class CardDataFull(@Column("CARD_DATA_ID") val id: Int, @Column("CARD_DATA_REFERENCE_ID") val referenceId: Int?,
                   @Column("CARD_DATA_CARD_ID_FK") val cardId: Int, @Column("CARD_DATA_CONTENT") val content: String,
                   @Column("EVENT_USER_ID_FK") val userId: Int, @Column("EVENT_PREV_CARD_DATA_ID_FK") val eventReferenceId: Int,
                   @Column("EVENT_TIME") val time: Date, @Column("CARD_DATA_TYPE") val type: CardType,
                   @Column("CARD_DATA_ORDER") val order: Int, @Column("EVENT_TYPE") val eventType: EventType)
