
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column

class ProjectWithEventCounts(@Column("PROJECT_ID") projectId: Int,
                             @Column("PROJECT_NAME") projectName: String,
                             @Column("PROJECT_SHORT_NAME") projectShortName: String,
                             @Column("PROJECT_DESCRIPTION") projectDescription: String?,
                             @Column("PROJECT_ARCHIVED") projectArchived: Boolean, //
                             @Column("EVENTS") val events: Long) {
    val project: Project

    init {
        this.project = Project(projectId, projectName, projectShortName, projectDescription, projectArchived)
    }
}
