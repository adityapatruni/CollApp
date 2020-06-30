
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column

class MilestoneCount(@Column("CARD_LABEL_VALUE_LIST_VALUE_FK") val milestoneId: Int?,
                     @Column("BOARD_COLUMN_DEFINITION_VALUE") val columnDefinition: ColumnDefinition,
                     @Column("MILESTONE_COUNT") val count: Long)
