
package io.collapp.model

class UserToCreate {

    var provider: String? = null
    var username: String? = null
    var password: String? = null
    var email: String? = null
    var displayName: String? = null
    var enabled: Boolean = false
    var roles: List<String>? = null

    constructor() {
    }

    constructor(provider: String, username: String) {
        this.provider = provider
        this.username = username
        enabled = true
    }
}
