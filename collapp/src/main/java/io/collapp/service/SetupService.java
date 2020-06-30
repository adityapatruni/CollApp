
package io.collapp.service;

import io.collapp.model.ConfigurationKeyValue;
import io.collapp.model.UserToCreate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SetupService {

	private final ConfigurationRepository configurationRepository;
	private final UserService userService;


	public SetupService(ConfigurationRepository configurationRepository, UserService userService) {
		this.configurationRepository = configurationRepository;
		this.userService = userService;
	}

	public void updateConfiguration(List<ConfigurationKeyValue> toUpdateOrCreate, UserToCreate user) {
		configurationRepository.updateOrCreate(toUpdateOrCreate);
		userService.createUser(user);
	}
}
