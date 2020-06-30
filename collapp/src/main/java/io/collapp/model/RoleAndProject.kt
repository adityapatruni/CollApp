
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column

class RoleAndProject(@Column("ROLE_NAME") val roleName: String, @Column("PROJECT_NAME") val projectName: String)
