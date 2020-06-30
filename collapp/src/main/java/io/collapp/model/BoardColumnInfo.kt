
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column
import io.collapp.model.BoardColumn.BoardColumnLocation

class BoardColumnInfo(@Column("BOARD_COLUMN_ID") val columnId: Int,
                      @Column("BOARD_COLUMN_NAME") val columnName: String,
                      @Column("BOARD_COLUMN_LOCATION") val columnLocation: BoardColumnLocation,
                      @Column("BOARD_ID") val boardId: Int,
                      @Column("BOARD_NAME") val boardName: String,
                      @Column("BOARD_SHORT_NAME") val boardShortName: String,
                      @Column("PROJECT_ID") val projectId: Int,
                      @Column("PROJECT_NAME") val projectName: String,
                      @Column("BOARD_COLUMN_DEFINITION_VALUE") val columnDefinition: ColumnDefinition,
                      @Column("BOARD_COLUMN_DEFINITION_COLOR") val columnColor: Int)
