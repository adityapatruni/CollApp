
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column


class ConfigurationKeyValue(@Column("CONF_KEY") first: Key,
                            @Column("CONF_VALUE") second: String?) : Pair<Key, String?>(first, second)
