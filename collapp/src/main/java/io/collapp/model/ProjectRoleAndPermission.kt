
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column

class ProjectRoleAndPermission(@Column("PROJECT_ID") val projectId: Int,
                               @Column("PROJECT_SHORT_NAME") val projectShortName: String, @Column("ROLE_NAME") val roleName: String,
                               @Column("ROLE_REMOVABLE") val removable: Boolean,
                               /** can be null  */
                               @Column("PERMISSION") val permission: Permission?) {

    /** is null if permission is null  */
    val category: PermissionCategory?

    init {
        this.category = permission?.category
    }
}
