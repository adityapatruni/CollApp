
package io.collapp.web.api;

import io.collapp.model.Key;
import io.collapp.service.ConfigurationRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Expose some configuration variables that must be visible to all users.
 */
@RestController
public class ConfigurationController {

	private final ConfigurationRepository configurationRepository;


	public ConfigurationController(ConfigurationRepository configurationRepository) {
		this.configurationRepository = configurationRepository;
	}

	@RequestMapping(value = "/api/configuration/max-upload-file-size", method = RequestMethod.GET)
	@ResponseBody
	public String getMaxUploadFileSize() {
		return configurationRepository.getValueOrNull(Key.MAX_UPLOAD_FILE_SIZE);
	}

}
