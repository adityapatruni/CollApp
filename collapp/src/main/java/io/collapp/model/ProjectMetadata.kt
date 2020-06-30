
package io.collapp.model

import io.collapp.model.util.DataOutputStreamUtils.*
import org.apache.commons.codec.digest.DigestUtils
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.DataOutputStream
import java.io.IOException
import java.util.*

class ProjectMetadata(val shortName: String, val labels: SortedMap<Int, CardLabel>, val labelListValues: SortedMap<Int, LabelListValueWithMetadata>,
                      val columnsDefinition: Map<ColumnDefinition, BoardColumnDefinition>) {
    val hash: String

    init {
        this.hash = hash(shortName, labels, labelListValues, columnsDefinition)
    }

    private fun hash(shortName: String, labels: SortedMap<Int, CardLabel>, labelListValues: SortedMap<Int, LabelListValueWithMetadata>,
                     columnsDefinition: Map<ColumnDefinition, BoardColumnDefinition>): String {

        val baos = ByteArrayOutputStream()
        val daos = DataOutputStream(baos)

        try {

            hash(daos, shortName)

            for (cl in labels.values) {
                hash(daos, cl)
            }

            for (l in labelListValues.values) {
                hash(daos, l)
            }

            for (b in columnsDefinition.values) {
                hash(daos, b)
            }

            daos.flush()
            return DigestUtils.sha256Hex(ByteArrayInputStream(baos.toByteArray()))
        } catch (e: IOException) {
            throw IllegalStateException(e)
        }

    }

    @Throws(IOException::class)
    private fun hash(daos: DataOutputStream, s: String) {
        writeNotNull(daos, s)
    }

    @Throws(IOException::class)
    private fun hash(daos: DataOutputStream, b: BoardColumnDefinition) {
        writeInts(daos, b.id, b.projectId)
        writeEnum(daos, b.value)
        writeInts(daos, b.color)
    }

    @Throws(IOException::class)
    private fun hash(daos: DataOutputStream, cl: CardLabel) {
        writeInts(daos, cl.id, cl.projectId)
        writeNotNull(daos, cl.name)
        writeInts(daos, cl.color)
        writeNotNull(daos, cl.unique)
        writeEnum(daos, cl.type)
        writeEnum(daos, cl.domain)
    }

    @Throws(IOException::class)
    private fun hash(daos: DataOutputStream, l: LabelListValueWithMetadata) {
        writeInts(daos, l.id, l.cardLabelId, l.order)
        writeNotNull(daos, l.value)
        for ((key, value) in l.metadata) {
            writeNotNull(daos, key)
            writeNotNull(daos, value)
        }
    }
}
