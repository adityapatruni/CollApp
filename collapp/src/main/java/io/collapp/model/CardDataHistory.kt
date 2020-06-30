
package io.collapp.model

import java.util.*

class CardDataHistory(val id: Int, val content: String, val order: Int, var userId: Int, var time: Date?, var updateUser: Int?,
                      var updateDate: Date?) {
    var updatedCount = 0
}
