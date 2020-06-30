
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column

class BoardInfo(@Column("BOARD_SHORT_NAME") val shortName: String,
                @Column("BOARD_NAME") val name: String?,
                @Column("BOARD_DESCRIPTION") val description: String?,
                @Column("BOARD_ARCHIVED") val archived: Boolean)
