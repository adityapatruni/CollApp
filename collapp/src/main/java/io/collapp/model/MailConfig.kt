
package io.collapp.model

import org.apache.commons.lang3.StringUtils
import org.apache.logging.log4j.LogManager
import org.springframework.core.io.ByteArrayResource
import org.springframework.core.io.support.EncodedResource
import org.springframework.core.io.support.PropertiesLoaderUtils
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl
import org.springframework.mail.javamail.MimeMessageHelper
import java.io.IOException

/**
 * See https://javamail.java.net/nonav/docs/api/com/sun/mail/smtp/package-summary.html for additional parameters.
 */
open class MailConfig(val host: String,
                      val port: Int?,
                      val protocol: String,
                      val username: String,
                      val password: String,
                      open val from: String,
                      val properties: String?) {

    open val minimalConfigurationPresent: Boolean
        get() = StringUtils.isNotBlank(host) && port != null && StringUtils.isNotBlank(protocol)
            && StringUtils.isNotBlank(from)

    @JvmOverloads
    open fun send(to: String, subject: String, text: String, html: String? = null) {

        toMailSender().send { mimeMessage ->
            val message = if (html == null)
                MimeMessageHelper(mimeMessage, "UTF-8")
            else
                MimeMessageHelper(mimeMessage, true, "UTF-8")
            message.setSubject(subject)
            message.setFrom(from)
            message.setTo(to)
            if (html == null) {
                message.setText(text, false)
            } else {
                message.setText(text, html)
            }
        }
    }

    private fun toMailSender(): JavaMailSender {
        val r = JavaMailSenderImpl()
        r.defaultEncoding = "UTF-8"
        r.host = host
        r.port = port ?: 0
        r.protocol = protocol
        r.username = username
        r.password = password
        if (properties != null) {
            try {
                val prop = PropertiesLoaderUtils.loadProperties(EncodedResource(ByteArrayResource(
                    properties.toByteArray(charset("UTF-8"))), "UTF-8"))
                r.javaMailProperties = prop
            } catch (e: IOException) {
                LOG.warn("error while setting the mail sender properties", e)
            }

        }
        return r
    }

    companion object {

        private val LOG = LogManager.getLogger()
    }
}
