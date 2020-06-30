
package io.collapp.web.helper;

import io.collapp.model.Permission;
import org.springframework.web.method.HandlerMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The annotation can be used at both method and class level. Method level annotation will take precedence over the
 * class one.
 *
 * If user does not have the related permission, a 403 error will be triggered.
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
public @interface ExpectPermission {
	Permission value();

	Class<? extends OwnershipChecker> ownershipChecker() default NoOpOwnershipChecker.class;

	public static final class Helper {

		private Helper() {
		}

		public static ExpectPermission getAnnotation(HandlerMethod handler) {
			return getAnnotation((Object) handler);
		}

		static ExpectPermission getAnnotation(Object handler) {
			if (handler == null || !(handler instanceof HandlerMethod)) {
				return null;
			}

			HandlerMethod hm = (HandlerMethod) handler;

			ExpectPermission expectPermission = hm.getMethodAnnotation(ExpectPermission.class);
			if (expectPermission == null) {
				expectPermission = hm.getBeanType().getAnnotation(ExpectPermission.class);
			}
			return expectPermission;
		}
	}
}
