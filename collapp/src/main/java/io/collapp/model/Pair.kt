
package io.collapp.model

open class Pair<T, U>(val first: T, val second: U) {
    companion object {

        fun <T, U> of(first: T, second: U): Pair<T, U> {
            return Pair(first, second)
        }
    }
}
