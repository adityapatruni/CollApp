
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column

class ProjectAndBoard(
    @Column("PROJECT_ID") projectId: Int,
    @Column("PROJECT_NAME") projectName: String?,
    @Column("PROJECT_SHORT_NAME") projectShortName: String?,
    @Column("PROJECT_DESCRIPTION") projectDescription: String?,
    @Column("PROJECT_ARCHIVED") projectArchived: Boolean, //
    @Column("BOARD_ID") boardId: Int,
    @Column("BOARD_NAME") boardName: String?,
    @Column("BOARD_SHORT_NAME") boardShortName: String?,
    @Column("BOARD_DESCRIPTION") boardDescription: String?,
    @Column("BOARD_ARCHIVED") boardArchived: Boolean) {

    val project: Project
    val board: Board

    init {
        this.project = Project(projectId, projectName, projectShortName, projectDescription, projectArchived)
        this.board = Board(boardId, boardName, boardShortName, boardDescription, projectId, boardArchived)
    }
}
