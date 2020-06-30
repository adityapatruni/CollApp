
package io.collapp.service;

import org.springframework.stereotype.Service;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import java.util.Properties;

@Service
public class LdapConnection {

	static class InitialDirContextCloseable extends InitialDirContext implements AutoCloseable {

		private InitialDirContextCloseable(Properties env) throws NamingException {
			super(env);
		}
	}

	InitialDirContextCloseable context(String providerUrl, String principal, String password) throws NamingException {
		Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, providerUrl);
		env.put(Context.SECURITY_PRINCIPAL, principal);
		env.put(Context.SECURITY_CREDENTIALS, password);
		return new InitialDirContextCloseable(env);
	}
}
