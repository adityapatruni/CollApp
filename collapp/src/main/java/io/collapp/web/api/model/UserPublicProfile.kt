
package io.collapp.web.api.model

import io.collapp.model.Event
import io.collapp.model.EventsCount
import io.collapp.model.ProjectWithEventCounts
import io.collapp.model.User

class UserPublicProfile(user: User, val dailyActivity: List<EventsCount>,
                        val activeProjects: List<ProjectWithEventCounts>, val latestActivityByPage: List<Event>) {
    val user: User

    init {
        // we remove the email
        this.user = User(user.id, user.provider, user.username, null, user.displayName,
            user.enabled, user.emailNotification, user.memberSince, user.skipOwnNotifications,
            user.userMetadataRaw)
    }
}
