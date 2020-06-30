
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column

class RoleAndMetadata(@Column("ROLE_NAME") val roleName: String, @Column("ROLE_REMOVABLE") val removable: Boolean,
                      @Column("ROLE_HIDDEN") val hidden: Boolean, @Column("ROLE_READONLY") val readOnly: Boolean)
