
package io.collapp.web.api;

import io.collapp.model.*;
import io.collapp.service.EventEmitter;
import io.collapp.service.PermissionService;
import io.collapp.service.PermissionService.RoleAndPermissions;
import io.collapp.service.ProjectService;
import io.collapp.web.api.model.CreateRole;
import io.collapp.web.api.model.UpdateRole;
import io.collapp.web.api.model.Users;
import io.collapp.web.helper.ExpectPermission;
import org.apache.commons.lang3.Validate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@ExpectPermission(Permission.PROJECT_ADMINISTRATION)
public class ProjectPermissionController {

	private final PermissionService permissionService;
	private final EventEmitter eventEmitter;
	private final ProjectService projectService;


	public ProjectPermissionController(PermissionService permissionService, EventEmitter eventEmitter,
			ProjectService projectService) {
		this.permissionService = permissionService;
		this.eventEmitter = eventEmitter;
		this.projectService = projectService;
	}

	@RequestMapping(value = "/api/project/{projectShortName}/role", method = RequestMethod.GET)
	public Map<String, RoleAndPermissions> findAllRolesAndRelatedPermissions(
			@PathVariable("projectShortName") String projectShortName) {
		int projectId = projectService.findIdByShortName(projectShortName);
		return permissionService.findAllRolesAndRelatedPermissionInProjectId(projectId);
	}

	@RequestMapping(value = "/api/project/{projectShortName}/role", method = RequestMethod.POST)
	public int createRole(@PathVariable("projectShortName") String projectShortName, @RequestBody CreateRole newRole) {
	    int projectId = projectService.findIdByShortName(projectShortName);
		int res = permissionService.createRoleInProjectId(new Role(newRole.getName()), projectId);
		eventEmitter.emitCreateRole(projectShortName);
		return res;
	}

	@RequestMapping(value = "/api/project/{projectShortName}/role/{roleName}", method = RequestMethod.POST)
	public void updateRole(@PathVariable("projectShortName") String projectShortName,
			@PathVariable("roleName") String roleName, @RequestBody UpdateRole updateRole) {

	    int projectId = projectService.findIdByShortName(projectShortName);
		RoleAndMetadata role = permissionService.findRoleInProjectByName(projectId, roleName);

		Validate.isTrue(!role.getReadOnly());

		permissionService.updatePermissionsToRoleInProjectId(new Role(roleName), updateRole.getPermissions(), projectId);
		eventEmitter.emitUpdatePermissionsToRole(projectShortName);
	}

	@RequestMapping(value = "/api/project/{projectShortName}/role/{roleName}", method = RequestMethod.DELETE)
	public void deleteRole(@PathVariable("projectShortName") String projectShortName,
			@PathVariable("roleName") String roleName) {
	    int projectId = projectService.findIdByShortName(projectShortName);

		RoleAndMetadata role = permissionService.findRoleInProjectByName(projectId, roleName);

		Validate.isTrue(role.getRemovable());

		permissionService.deleteRoleInProjectId(new Role(roleName), projectId);
		eventEmitter.emitDeleteRole(projectShortName);
	}

	@RequestMapping(value = "/api/project/{projectShortName}/role/{roleName}/users/", method = RequestMethod.GET)
	public List<User> findUserByRole(@PathVariable("projectShortName") String projectShortName,
			@PathVariable("roleName") String roleName) {
	    int projectId = projectService.findIdByShortName(projectShortName);
		return permissionService.findUserByRoleAndProjectId(new Role(roleName), projectId);
	}

	@RequestMapping(value = "/api/project/{projectShortName}/role/{roleName}/users/", method = RequestMethod.POST)
	public void assignUsersToRole(@PathVariable("projectShortName") String projectShortName,
			@PathVariable("roleName") String roleName, @RequestBody Users usersToAdd) {

	    int projectId = projectService.findIdByShortName(projectShortName);
		permissionService.assignRoleToUsersInProjectId(new Role(roleName), usersToAdd.getUserIds(), projectId);
		eventEmitter.emitAssignRoleToUsers(roleName, projectShortName);
	}

	@RequestMapping(value = "/api/project/{projectShortName}/role/{roleName}/remove/", method = RequestMethod.POST)
	public void removeRoleToUsers(@PathVariable("projectShortName") String projectShortName,
			@PathVariable("roleName") String roleName, @RequestBody Users usersToRemove) {

	    int projectId = projectService.findIdByShortName(projectShortName);
		permissionService.removeRoleToUsersInProjectId(new Role(roleName), usersToRemove.getUserIds(), projectId);
		eventEmitter.emitRemoveRoleToUsers(roleName, projectShortName);
	}

	@RequestMapping(value = "/api/project/{projectShortName}/role/available-permissions", method = RequestMethod.GET)
	public Map<PermissionCategory, List<Permission>> existingPermissions(
			@PathVariable("projectShortName") String projectShortName) {
		Map<PermissionCategory, List<Permission>> byCategory = new LinkedHashMap<>();
		for (PermissionCategory pc : PermissionCategory.values()) {
			if (!pc.getOnlyForBase()) {
				byCategory.put(pc, new ArrayList<Permission>());
			}
		}
		for (Permission permission : Permission.values()) {
			if (!permission.getOnlyForBase() && byCategory.containsKey(permission.getCategory())) {
				byCategory.get(permission.getCategory()).add(permission);
			}
		}
		return byCategory;
	}

}
