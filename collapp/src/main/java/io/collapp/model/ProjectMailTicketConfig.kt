

package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column
import io.collapp.common.Json
import java.util.*

class ProjectMailTicketConfig(@Column("MAIL_CONFIG_ID") val id: Int,
                              @Column("MAIL_CONFIG_NAME") val name: String,
                              @Column("MAIL_CONFIG_ENABLED") val enabled: Boolean,
                              @Column("MAIL_CONFIG_PROJECT_ID_FK") val projectId: Int,
                              @Column("MAIL_CONFIG_LAST_CHECKED") val lastChecked: Date?,
                              @Column("MAIL_CONFIG_CONFIG") @Transient val configJson: String,
                              @Column("MAIL_CONFIG_SUBJECT") val subject: String,
                              @Column("MAIL_CONFIG_BODY") val body: String) {

    val config: ProjectMailTicketConfigData
    val entries: List<ProjectMailTicket>

    init {
        config = Json.GSON.fromJson(configJson, ProjectMailTicketConfigData::class.java)
        entries = ArrayList<ProjectMailTicket>()
    }
}
