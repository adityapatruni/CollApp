
package io.collapp.web.security.login.oauth;

import io.collapp.web.security.SecurityConfiguration.SessionHandler;
import io.collapp.web.security.SecurityConfiguration.Users;
import io.collapp.web.security.login.oauth.OAuthResultHandler.OAuthResultHandlerAdapter;
import org.scribe.builder.ServiceBuilder;

public class GithubHandler extends OAuthResultHandlerAdapter {

    private GithubHandler(OAuthServiceBuilder serviceBuilder, OAuthRequestBuilder reqBuilder, String apiKey,
			String apiSecret, String callback, Users users, SessionHandler sessionHandler, String errorPage) {
		super("oauth.github",//
				"https://api.github.com/user",//
				UserInfo.class, "code",//
				users,//
				sessionHandler,//
				errorPage,//
				serviceBuilder.build(new Github20Api(), apiKey, apiSecret, callback), reqBuilder);
	}

	private static class UserInfo implements RemoteUserProfile {
		String login;

		@Override
		public boolean valid(Users users, String provider) {
			return users.userExistsAndEnabled(provider, login);
		}

		@Override
		public String username() {
			return login;
		}
	}

	public static final OAuthResultHandlerFactory FACTORY = new OAuthResultHandlerFactory.Adapter() {

        @Override
        public OAuthResultHandler build(OAuthServiceBuilder serviceBuilder,
                OAuthRequestBuilder reqBuilder, OAuthProvider provider,
                String callback, Users users, SessionHandler sessionHandler,
                String errorPage) {
            return new GithubHandler(serviceBuilder, reqBuilder, provider.getApiKey(), provider.getApiSecret(), callback, users, sessionHandler, errorPage);
        }

        @Override
        public boolean hasConfigurableBaseUrl() {
            return false;
        }
    };

}
