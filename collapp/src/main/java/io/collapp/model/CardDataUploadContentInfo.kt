
package io.collapp.model

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column

class CardDataUploadContentInfo(@Column("DIGEST") val digest: String, @Column("SIZE") val size: Int,
                                @Column("CONTENT_TYPE") val contentType: String)
