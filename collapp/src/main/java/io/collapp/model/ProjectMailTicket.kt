
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column

class ProjectMailTicket(@Column("MAIL_TICKET_ID") val id: Int,
                        @Column("MAIL_TICKET_NAME") val name: String,
                        @Column("MAIL_TICKET_ENABLED") val enabled: Boolean,
                        @Column("MAIL_TICKET_ALIAS") val alias: String,
                        @Column("MAIL_TICKET_USE_ALIAS") val sendByAlias: Boolean,
                        @Column("MAIL_TICKET_NOTIFICATION_OVERRIDE") val notificationOverride: Boolean,
                        @Column("MAIL_TICKET_SUBJECT") val subject: String?,
                        @Column("MAIL_TICKET_BODY") val body: String?,
                        @Column("MAIL_TICKET_COLUMN_ID_FK") val columnId: Int,
                        @Column("MAIL_TICKET_CONFIG_ID_FK") val configId: Int,
                        @Column("MAIL_TICKET_METADATA") @Transient val metadataRaw: String?) {

    val metadata: String?

    init {
        metadata = metadataRaw
    }
}
