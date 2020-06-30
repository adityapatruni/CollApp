
package io.collapp.web.api;

import io.collapp.model.ApiHook;
import io.collapp.model.Permission;
import io.collapp.service.ApiHooksService;
import io.collapp.web.api.model.PluginCode;
import io.collapp.web.helper.ExpectPermission;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class ApiHooksController {

    private final ApiHooksService apiHooksService;

    public ApiHooksController(ApiHooksService apiHooksService) {
        this.apiHooksService = apiHooksService;
    }

    @ExpectPermission(Permission.ADMINISTRATION)
    @RequestMapping(value = "/api/plugin", method = RequestMethod.POST)
    public ApiHook addGlobalPlugin(@RequestBody PluginCode plugin) {
        apiHooksService.createApiHook(plugin.getName(), plugin.getCode(), plugin.getProperties(), plugin.getProjects(), plugin.getMetadata());
        return apiHooksService.findByName(plugin.getName());
    }

    @ExpectPermission(Permission.ADMINISTRATION)
    @RequestMapping(value = "/api/plugin/{name}/enable/{status}", method = RequestMethod.POST)
    public void enable(@PathVariable("name") String name, @PathVariable("status") boolean status) {
        apiHooksService.enable(name, status);
    }

    @ExpectPermission(Permission.ADMINISTRATION)
    @RequestMapping(value = "/api/plugin", method = RequestMethod.GET)
    public List<ApiHook> listPlugins() {
        return apiHooksService.findAllPlugins();
    }

    @ExpectPermission(Permission.ADMINISTRATION)
    @RequestMapping(value = "/api/plugin/{name}", method = RequestMethod.DELETE)
    public void deletePlugin(@PathVariable("name") String name) {
        apiHooksService.deleteHook(name);
    }

    @ExpectPermission(Permission.ADMINISTRATION)
    @RequestMapping(value = "/api/plugin/{name}", method = RequestMethod.POST)
    public void update(@PathVariable("name") String name, @RequestBody PluginCode plugin) {
        apiHooksService.updateApiHook(name, plugin.getCode(), plugin.getProperties(), plugin.getProjects(), plugin.getMetadata());
    }

    @ExpectPermission(Permission.GLOBAL_HOOK_API_ACCESS)
    @RequestMapping(value = "/api/api-hook/hook/{name}", method = {RequestMethod.GET, RequestMethod.POST})
    public void handleHook(@PathVariable("name") String name, HttpServletRequest request, HttpServletResponse response) throws IOException {
        apiHooksService.handleHook(name, request, response);
    }

    @ExpectPermission(Permission.PROJECT_HOOK_API_ACCESS)
    @RequestMapping(value = "/api/api-hook/project/{projectShortName}/hook/{name}", method = {RequestMethod.GET, RequestMethod.POST})
    public void handleHook(@PathVariable("projectShortName") String projectShortName, @PathVariable("name") String name, HttpServletRequest request, HttpServletResponse response) throws IOException {
        apiHooksService.handleHook(projectShortName, name, request, response);
    }
}
