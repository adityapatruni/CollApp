
package io.collapp.web.helper;

import io.collapp.model.UserWithPermission;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class NoOpOwnershipChecker implements OwnershipChecker {

	@Override
	public boolean hasOwnership(HttpServletRequest request, UserWithPermission user) {
		return false;
	}
}
