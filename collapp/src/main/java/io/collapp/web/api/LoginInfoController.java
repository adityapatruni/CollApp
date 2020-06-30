
package io.collapp.web.api;

import com.google.gson.reflect.TypeToken;
import io.collapp.common.Json;
import io.collapp.model.Key;
import io.collapp.model.Permission;
import io.collapp.service.ConfigurationRepository;
import io.collapp.web.helper.ExpectPermission;
import io.collapp.web.security.LoginHandler;
import io.collapp.web.security.login.OAuthLogin;
import io.collapp.web.security.login.oauth.OAuthResultHandlerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.Map.Entry;

@RestController
@ExpectPermission(Permission.ADMINISTRATION)
public class LoginInfoController {

    private final ConfigurationRepository configurationRepository;
    private final OAuthLogin oauthLogin;


    public LoginInfoController(ConfigurationRepository configurationRepository, OAuthLogin oauthLogin) {
        this.configurationRepository = configurationRepository;
        this.oauthLogin = oauthLogin;
    }

    @RequestMapping(value = "/api/login/all", method = RequestMethod.GET)
    public Collection<String> getAllLoginProviders(HttpServletRequest request) {
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        List<String> res = new ArrayList<>();
        for(LoginHandler handler : ctx.getBeansOfType(LoginHandler.class).values()) {
            res.addAll(handler.getAllHandlerNames());
        }
        Collections.sort(res);
        return res;
    }

    public static class OAuthProviderInfo implements Comparable<OAuthProviderInfo> {
        private final String name;
        private final boolean hasConfigurableBaseUrl;
        private final boolean isConfigurableInstance;

        @Override
        public int compareTo(OAuthProviderInfo o) {
            return name.compareTo(o.name);
        }

        @java.beans.ConstructorProperties({ "name", "hasConfigurableBaseUrl",
            "isConfigurableInstance" }) public OAuthProviderInfo(String name, boolean hasConfigurableBaseUrl,
            boolean isConfigurableInstance) {
            this.name = name;
            this.hasConfigurableBaseUrl = hasConfigurableBaseUrl;
            this.isConfigurableInstance = isConfigurableInstance;
        }

        public String getName() {
            return this.name;
        }

        public boolean isHasConfigurableBaseUrl() {
            return this.hasConfigurableBaseUrl;
        }

        public boolean isConfigurableInstance() {
            return this.isConfigurableInstance;
        }
    }

    @RequestMapping(value = "/api/login/oauth/all", method = RequestMethod.GET)
    public Collection<OAuthProviderInfo> getAllUnprefixedOauthProviders() {
        List<OAuthProviderInfo> res = new ArrayList<>();
        for(Entry<String, OAuthResultHandlerFactory> e : oauthLogin.getAllHandlers().entrySet()) {
            res.add(new OAuthProviderInfo(e.getKey(), e.getValue().hasConfigurableBaseUrl(), e.getValue().isConfigurableInstance()));
        }
        Collections.sort(res);
        return res;
    }

    @RequestMapping(value = "/api/login/all-base-with-activation-status", method = RequestMethod.GET)
    public Map<String, Boolean> getLoginWithActivationStatus(HttpServletRequest request) {

        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        Map<String, Boolean> res = new HashMap<>();
        for(LoginHandler handler : ctx.getBeansOfType(LoginHandler.class).values()) {
            res.put(handler.getBaseProviderName().toUpperCase(Locale.ENGLISH), false);
        }

        List<String> enabled = Json.GSON.fromJson(configurationRepository.getValue(Key.AUTHENTICATION_METHOD), (new TypeToken<List<String>>() {}).getType());
        for(String e : enabled) {
            res.put(e.toUpperCase(Locale.ENGLISH), true);
        }

        return res;
    }

}
