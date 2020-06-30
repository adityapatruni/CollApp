
package io.collapp.web.security.login;

import io.collapp.web.security.LoginHandler.AbstractLoginHandler;
import io.collapp.web.security.Redirector;
import io.collapp.web.security.SecurityConfiguration.SessionHandler;
import io.collapp.web.security.SecurityConfiguration.User;
import io.collapp.web.security.SecurityConfiguration.Users;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.removeStart;

public class LdapLogin extends AbstractLoginHandler {

	static final String USER_PROVIDER = "ldap";

	private final String errorPage;
	private final LdapAuthenticator ldap;

	public LdapLogin(Users users, SessionHandler sessionHandler, LdapAuthenticator ldap, String errorPage) {
		super(users, sessionHandler);
		this.ldap = ldap;
		this.errorPage = errorPage;
	}

	@Override
	public boolean doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		if (!"POST".equalsIgnoreCase(req.getMethod())) {
			return false;
		}

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		if (authenticate(username, password)) {
			// FIXME refactor out
			String url = Redirector.cleanupRequestedUrl(req.getParameter("reqUrl"), req);
			User user = users.findUserByName(USER_PROVIDER, username);
			sessionHandler.setUser(user.getId(), user.isAnonymous(), req, resp);
			Redirector.sendRedirect(req, resp, url, Collections.<String, List<String>> emptyMap());
		} else {
			Redirector.sendRedirect(req, resp, req.getContextPath() + "/" + removeStart(errorPage, "/"), Collections.<String, List<String>> emptyMap());
		}
		return true;

	}

	private boolean authenticate(String username, String password) {
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || !ldap.checkUserAvailability(username) || !users.userExistsAndEnabled(USER_PROVIDER, username)) {
			return false;
		}

		return ldap.authenticate(username, password);
	}

	@Override
	public Map<String, Object> modelForLoginPage(HttpServletRequest request) {
		Map<String, Object> r = super.modelForLoginPage(request);
		r.put("loginLdap", "block");
		return r;
	}

	public interface LdapAuthenticator {
	    boolean authenticate(String username, String password);
	    boolean checkUserAvailability(String username);
	}

    @Override
    public List<String> getAllHandlerNames() {
        return Collections.singletonList(USER_PROVIDER);
    }

    @Override
    public String getBaseProviderName() {
        return USER_PROVIDER;
    }

}
