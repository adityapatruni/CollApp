
package io.collapp.web.api.model

/**
 * Plugin configuration model
 *
 * @param name Integration name
 * @param code Javascript code
 * @param properties Map of key-value properties
 * @param projects List of projects that this plugin is enabled for
 * @param metadata Integration metadata. Contains description and configuration for the properties
 *
 * Properties are defined in the metadata parameter. A configuration object is contained, where each property has a label and type attached to it.
 */
class PluginCode(var name: String, var code: String?, var properties: Map<String, String>?, var projects: List<String> ?, var metadata: Map<String, Any>?)
