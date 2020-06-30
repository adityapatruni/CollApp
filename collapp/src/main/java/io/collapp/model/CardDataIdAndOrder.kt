
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column


class CardDataIdAndOrder(@Column("CARD_DATA_ID") first: Int, @Column("CARD_DATA_ORDER") second: Int) : Pair<Int, Int>(first, second)
