
package io.collapp.model

enum class Key {
    SETUP_COMPLETE, //
    BASE_APPLICATION_URL, //
    AUTHENTICATION_METHOD, //
    //
    LDAP_SERVER_URL, // ldap://localhost:10389
    LDAP_MANAGER_DN, // uid=admin,ou=system
    LDAP_MANAGER_PASSWORD, // secret
    //
    LDAP_USER_SEARCH_BASE, // ou=system
    LDAP_USER_SEARCH_FILTER, // uid={0}
    LDAP_AUTOCREATE_MISSING_ACCOUNT,
    //
    @Deprecated("") // kept for retrocompatibility
    PERSONA_AUDIENCE, // http://localhost:8080 (
    //
    OAUTH_CONFIGURATION,
    //
    @Deprecated("") // kept for retrocompatibility
    USE_HTTPS,
    //
    ENABLE_ANON_USER,
    //
    SMTP_ENABLED,
    SMTP_CONFIG, EMAIL_NOTIFICATION_TIMESPAN,
    //
    TRELLO_API_KEY,
    //
    MAX_UPLOAD_FILE_SIZE, // for uploaded body by the user (import data is not under this limit)
    //
    TEST_PLACEHOLDER
}
