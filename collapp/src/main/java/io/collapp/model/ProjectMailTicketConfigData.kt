
package io.collapp.model

import io.collapp.common.Json
import org.springframework.core.io.ByteArrayResource
import org.springframework.core.io.support.EncodedResource
import org.springframework.core.io.support.PropertiesLoaderUtils
import java.util.*

class ProjectMailTicketConfigData(val inboundProtocol: String,
                                  val inboundServer: String,
                                  val inboundPort: Int,
                                  val inboundUser: String,
                                  val inboundPassword: String,
                                  val inboundInboxFolder: String?,
                                  val inboundProperties: String?,
                                  val outboundServer: String,
                                  val outboundPort: Int,
                                  val outboundProtocol: String,
                                  val outboundUser: String,
                                  val outboundPassword: String,
                                  val outboundAddress: String,
                                  val outboundProperties: String?) {

    override fun toString(): String {
        return Json.GSON.toJson(this)
    }

    fun generateOutboundProperties(): Properties {
        val properties = Properties()

        if(outboundProperties != null) {
            properties.putAll(PropertiesLoaderUtils.loadProperties(EncodedResource(ByteArrayResource(
                outboundProperties.toByteArray(charset("UTF-8"))), "UTF-8")))
        }

        return properties
    }

    fun generateInboundProperties(): Properties {
        val properties = Properties()

        if(inboundProperties != null) {
            properties.putAll(PropertiesLoaderUtils.loadProperties(EncodedResource(ByteArrayResource(
                inboundProperties.toByteArray(charset("UTF-8"))), "UTF-8")))
        }

        return properties
    }
}
