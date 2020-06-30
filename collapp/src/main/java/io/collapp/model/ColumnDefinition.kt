
package io.collapp.model

enum class ColumnDefinition {
    OPEN {
        override // red
        val defaultColor: Int
            get() = 0xd9534f
    },
    CLOSED {
        override // green
        val defaultColor: Int
            get() = 0x5cb85c
    },
    BACKLOG {
        override // blue
        val defaultColor: Int
            get() = 0x428bca
    },
    DEFERRED {
        override // yellow
        val defaultColor: Int
            get() = 0xf0ad4e
    };

    abstract val defaultColor: Int
}
