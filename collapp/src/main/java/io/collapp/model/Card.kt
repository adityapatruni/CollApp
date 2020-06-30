
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column

open class Card(@Column("CARD_ID") val id: Int, //
                @Column("CARD_NAME") val name: String, //
                @Column("CARD_SEQ_NUMBER") val sequence: Int// sequence number, public identifier
                , //
                @Column("CARD_ORDER") val order: Int, //
                @Column("CARD_BOARD_COLUMN_ID_FK") val columnId: Int, //
                @Column("CARD_USER_ID_FK") val userId: Int)
