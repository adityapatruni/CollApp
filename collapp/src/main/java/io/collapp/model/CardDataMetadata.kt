
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column

open class CardDataMetadata(@Column("CARD_DATA_ID") val id: Int, @Column("CARD_DATA_CARD_ID_FK") val cardId: Int,
                            @Column("CARD_DATA_REFERENCE_ID") val referenceId: Int?, @Column("CARD_DATA_TYPE") val type: CardType,
                            @Column("CARD_DATA_ORDER") val order: Int)
