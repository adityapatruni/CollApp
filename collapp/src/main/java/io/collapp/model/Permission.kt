
package io.collapp.model

import org.apache.commons.lang3.Validate
import java.util.*

enum class Permission private constructor(
        //

        val category: PermissionCategory,
        /**
         * only for base permission, if false: cannot be used in Project level permission
         */
        val onlyForBase: Boolean = false) {
    /* access to the admin tool */
    ADMINISTRATION(PermissionCategory.APPLICATION, true), //

    /* role for admin project */
    PROJECT_ADMINISTRATION(PermissionCategory.PROJECT),

    /* role for reading a board and related column/card/comments */
    READ(PermissionCategory.BOARD),


    /* can create new column */
    CREATE_COLUMN(PermissionCategory.COLUMN), //

    /* can reorder column */
    MOVE_COLUMN(PermissionCategory.COLUMN), //

    /* can rename column */
    RENAME_COLUMN(PermissionCategory.COLUMN), //

    /* can create cards */
    CREATE_CARD(PermissionCategory.CARD), //
    UPDATE_CARD(PermissionCategory.CARD), //
    MOVE_CARD(PermissionCategory.CARD), //

    //
    /* can create a comment */
    CREATE_CARD_COMMENT(PermissionCategory.CARD), //

    /* can update and delete comments from other users */
    UPDATE_CARD_COMMENT(PermissionCategory.CARD), //
    DELETE_CARD_COMMENT(PermissionCategory.CARD), //

    /* can manage a action list */
    MANAGE_ACTION_LIST(PermissionCategory.CARD), //

    // file related
    CREATE_FILE(PermissionCategory.CARD), //
    UPDATE_FILE(PermissionCategory.CARD), //
    DELETE_FILE(PermissionCategory.CARD), //
    //

    // label related
    MANAGE_LABEL_VALUE(PermissionCategory.CARD), //
    //

    /* can update the _current_ user profile */
    UPDATE_PROFILE(PermissionCategory.APPLICATION), //

    SEARCH(PermissionCategory.APPLICATION),


    //this permissions must be used for accessing the hook endpoints defined in ApiHooksController
    //special "technical" users will be defined
    GLOBAL_HOOK_API_ACCESS(PermissionCategory.APPLICATION, true),
    PROJECT_HOOK_API_ACCESS(PermissionCategory.APPLICATION);


    companion object {

        private val AVAILABLE_PERMISSION_FOR_PROJECT: Set<Permission>

        init {
            val p = EnumSet.noneOf(Permission::class.java)
            for (perm in Permission.values()) {
                if (!perm.onlyForBase) {
                    p.add(perm)
                }
            }
            AVAILABLE_PERMISSION_FOR_PROJECT = Collections.unmodifiableSet(p)
        }

        fun ensurePermissionForProject(permissions: Set<Permission>) {
            Validate.isTrue(Permission.AVAILABLE_PERMISSION_FOR_PROJECT.containsAll(permissions),
                    "permission at project level only: $permissions contain a onlyForBase Permission.")
        }
    }
}
