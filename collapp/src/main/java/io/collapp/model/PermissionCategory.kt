
package io.collapp.model

enum class PermissionCategory {
    APPLICATION(true), PROJECT, BOARD, COLUMN, CARD;

    /**
     * only for base permission, if false: cannot be used in Project level permission
     */
    val onlyForBase: Boolean

    private constructor() {
        onlyForBase = false
    }

    private constructor(onlyForBase: Boolean) {
        this.onlyForBase = onlyForBase
    }
}
