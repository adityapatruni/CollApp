
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column

open class CardData(@Column("CARD_DATA_ID") id: Int,
                    @Column("CARD_DATA_CARD_ID_FK") cardId: Int,
                    @Column("CARD_DATA_REFERENCE_ID") referenceId: Int?,
                    @Column("CARD_DATA_TYPE") type: CardType,
                    @Column("CARD_DATA_CONTENT") val content: String?,
                    @Column("CARD_DATA_ORDER") order: Int) : CardDataMetadata(id, cardId, referenceId, type, order)
