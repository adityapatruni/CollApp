
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column

open class Board(@Column("BOARD_ID") val id: Int,
            @Column("BOARD_NAME") val name: String?,
            @Column("BOARD_SHORT_NAME") val shortName: String?,
            @Column("BOARD_DESCRIPTION") val description: String?,
            @Column("BOARD_PROJECT_ID_FK") val projectId: Int,
            @Column("BOARD_ARCHIVED") val archived: Boolean)
