
package io.collapp.web.helper;

import io.collapp.model.UserWithPermission;

import javax.servlet.http.HttpServletRequest;

public interface OwnershipChecker {

	boolean hasOwnership(HttpServletRequest request, UserWithPermission user);
}
