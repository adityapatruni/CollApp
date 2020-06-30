
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column

class CardIdAndContent(@Column("CARD_DATA_ID") val id: Int, @Column("CARD_DATA_CONTENT") val content: String)
