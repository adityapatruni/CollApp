
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column
import java.util.*

open class CardFull(
        @Column("CARD_ID") id: Int, //
        @Column("CARD_NAME") name: String, //
        @Column("CARD_SEQ_NUMBER") sequence: Int, //
        @Column("CARD_ORDER") order: Int, //
        @Column("CARD_BOARD_COLUMN_ID_FK") columnId: Int, //
        @Column("CREATE_USER") createUserId: Int, //
        @Column("CREATE_TIME") val createTime: Date, //
        @Column("LAST_UPDATE_USER") val lastUpdateUserId: Int?, @Column("LAST_UPDATE_TIME") val lastUpdateTime: Date?,
        @Column("BOARD_COLUMN_DEFINITION_VALUE") val columnDefinition: ColumnDefinition,
        @Column("BOARD_SHORT_NAME") val boardShortName: String, @Column("PROJECT_SHORT_NAME") val projectShortName: String) : Card(id, name, sequence, order, columnId, createUserId)
