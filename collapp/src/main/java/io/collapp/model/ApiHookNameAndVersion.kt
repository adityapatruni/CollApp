
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column

class ApiHookNameAndVersion(@Column("API_HOOK_NAME") val name: String, @Column("API_HOOK_VERSION") val version: Int)
