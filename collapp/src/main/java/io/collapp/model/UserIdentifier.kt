
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column

/**
 * Identify a user in the collapp system
 */
class UserIdentifier(@Column("USER_PROVIDER") val provider: String, @Column("USER_NAME") val username: String)
