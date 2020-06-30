
package io.collapp.model

import java.util.*

class Role(name: String) {

    val name: String

    init {
        this.name = name.toUpperCase(Locale.ENGLISH)
    }

    override fun equals(obj: Any?): Boolean {
        return if (obj != null && obj is Role) name == obj.name else false
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    companion object {

        val ADMIN_ROLE = Role("ADMIN")
        val DEFAULT_ROLE = Role("DEFAULT")
    }
}
