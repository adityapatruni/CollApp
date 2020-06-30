
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column

open class Project(@Column("PROJECT_ID") val id: Int,
                   @Column("PROJECT_NAME") val name: String?,
                   @Column("PROJECT_SHORT_NAME") val shortName: String?,
                   @Column("PROJECT_DESCRIPTION") val description: String?,
                   @Column("PROJECT_ARCHIVED") val archived: Boolean)
