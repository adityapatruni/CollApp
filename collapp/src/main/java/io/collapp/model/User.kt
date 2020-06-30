
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column
import io.collapp.common.Json
import org.apache.commons.lang3.StringUtils
import org.apache.commons.lang3.builder.EqualsBuilder
import org.apache.commons.lang3.builder.HashCodeBuilder
import java.util.*

open class User(@Column("USER_ID") val id: Int,
                @Column("USER_PROVIDER") val provider: String?,
                @Column("USER_NAME") val username: String?,
                @Column("USER_EMAIL") val email: String?,
                @Column("USER_DISPLAY_NAME") val displayName: String?,
                @Column("USER_ENABLED") enabled: Boolean?,
                @Column("USER_EMAIL_NOTIFICATION") val emailNotification: Boolean,
                @Column("USER_MEMBER_SINCE") val memberSince: Date?,
                @Column("USER_SKIP_OWN_NOTIFICATIONS") val skipOwnNotifications: Boolean,
                @Column("USER_METADATA") @Transient val userMetadataRaw: String?) {
    val enabled: Boolean
    val userMetadata: UserMetadata?

    init {
        this.enabled = enabled ?: true
        this.userMetadata = Json.GSON.fromJson(userMetadataRaw, UserMetadata::class.java)
    }

    public open operator override fun equals(obj: Any?): Boolean {
        if (obj == null || obj !is User) {
            return false
        }
        return EqualsBuilder().append(id, obj.id).append(provider, obj.provider).append(username, obj.username).append(email, obj.email).append(displayName, obj.displayName).append(enabled, obj.enabled).append(emailNotification, obj.emailNotification).append(skipOwnNotifications, obj.skipOwnNotifications).append(userMetadata, obj.userMetadata).isEquals
    }

    public open override fun hashCode(): Int {
        return HashCodeBuilder().append(id).append(provider).append(username).append(email).append(displayName).append(enabled).append(emailNotification).append(skipOwnNotifications).toHashCode()
    }

    val anonymous: Boolean
        get() = "system" == provider && "anonymous" == username

    fun canSendEmail(): Boolean {
        return enabled && emailNotification && StringUtils.isNotBlank(email)
    }
}
