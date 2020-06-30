
package io.collapp.web.api;

import io.collapp.model.*;
import io.collapp.service.EventEmitter;
import io.collapp.service.PermissionService;
import io.collapp.service.PermissionService.RoleAndPermissions;
import io.collapp.web.api.model.CreateRole;
import io.collapp.web.api.model.UpdateRole;
import io.collapp.web.api.model.Users;
import io.collapp.web.helper.ExpectPermission;
import org.apache.commons.lang3.Validate;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@ExpectPermission(Permission.ADMINISTRATION)
public class PermissionController {

    private final PermissionService permissionService;
    private final EventEmitter eventEmitter;


    public PermissionController(PermissionService permissionService, EventEmitter eventEmitter) {
        this.permissionService = permissionService;
        this.eventEmitter = eventEmitter;
    }

    /**
     * @return a map roleName => list of permission
     */
    @RequestMapping(value = "/api/role", method = RequestMethod.GET)
    public Map<String, RoleAndPermissions> findAllRolesAndRelatedPermissions() {
        return permissionService.findAllRolesAndRelatedPermission();
    }

    @RequestMapping(value = "/api/role", method = RequestMethod.POST)
    public int createRole(@RequestBody CreateRole newRole) {
        int res = permissionService.createRole(new Role(newRole.getName()));
        eventEmitter.emitCreateRole();
        return res;
    }

    @RequestMapping(value = "/api/role/ANONYMOUS/toggle-search-permission", method = RequestMethod.POST)
    public void toggleSearchPermission(@RequestBody ToggleSearchPermission addSearch) {
        Set<Permission> permissions = EnumSet.of(Permission.READ);
        if (addSearch.value) {
            permissions.add(Permission.SEARCH);
        }
        permissionService.updatePermissionsToRole(new Role("ANONYMOUS"), permissions);
        eventEmitter.emitUpdatePermissionsToRole();
    }

    public static class ToggleSearchPermission {
        private boolean value;

        public boolean isValue() {
            return this.value;
        }

        public void setValue(boolean value) {
            this.value = value;
        }
    }

    @RequestMapping(value = "/api/role/{roleName}", method = RequestMethod.POST)
    public void updateRole(@PathVariable("roleName") String roleName, @RequestBody UpdateRole updateRole) {

        RoleAndMetadata role = permissionService.findRoleByName(roleName);
        Validate.isTrue(!role.getReadOnly());

        permissionService.updatePermissionsToRole(new Role(roleName), updateRole.getPermissions());
        eventEmitter.emitUpdatePermissionsToRole();
    }

    @RequestMapping(value = "/api/role/{roleName}", method = RequestMethod.DELETE)
    public void deleteRole(@PathVariable("roleName") String roleName) {

        RoleAndMetadata role = permissionService.findRoleByName(roleName);
        Validate.isTrue(role.getRemovable());

        permissionService.deleteRole(new Role(roleName));
        eventEmitter.emitDeleteRole();
    }

    @RequestMapping(value = "/api/user-roles/{userId}/", method = RequestMethod.GET)
    public PermissionService.ProjectRoleFullHolder findUserRoles(@PathVariable("userId") int userId) {
        return permissionService.findUserRolesByProject(userId);
    }

    @RequestMapping(value = "/api/role/{roleName}/users/", method = RequestMethod.GET)
    public List<User> findUserByRole(@PathVariable("roleName") String roleName) {
        return permissionService.findUserByRole(new Role(roleName));
    }

    @RequestMapping(value = "/api/role/{roleName}/users/", method = RequestMethod.POST)
    public void assignUsersToRole(@PathVariable("roleName") String roleName, @RequestBody Users usersToAdd) {
        permissionService.assignRoleToUsers(new Role(roleName), usersToAdd.getUserIds());
        eventEmitter.emitAssignRoleToUsers(roleName);
    }

    @RequestMapping(value = "/api/role/{roleName}/remove/", method = RequestMethod.POST)
    public void removeRoleToUsers(@PathVariable("roleName") String roleName, @RequestBody Users usersToRemove) {
        permissionService.removeRoleToUsers(new Role(roleName), usersToRemove.getUserIds());
        eventEmitter.emitRemoveRoleToUsers(roleName);
    }

    @RequestMapping(value = "/api/role/available-permissions", method = RequestMethod.GET)
    public Map<PermissionCategory, List<Permission>> existingPermissions() {
        Map<PermissionCategory, List<Permission>> byCategory = new LinkedHashMap<>();
        for (PermissionCategory pc : PermissionCategory.values()) {
            byCategory.put(pc, new ArrayList<Permission>());
        }
        for (Permission permission : Permission.values()) {
            byCategory.get(permission.getCategory()).add(permission);
        }
        return byCategory;
    }
}
