
package io.collapp.web.helper;

import io.collapp.web.api.model.ValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class GeneralHandlerExceptionResolver implements HandlerExceptionResolver {

	private static final Logger LOG = LogManager.getLogger();

	private final Map<Class<? extends Throwable>, Integer> statusCodeResolver = new LinkedHashMap<>();

	public GeneralHandlerExceptionResolver() {
		// add the exceptions from the less generic to the more one
		statusCodeResolver.put(EmptyResultDataAccessException.class, HttpStatus.NOT_FOUND.value());
		statusCodeResolver.put(ValidationException.class, HttpStatus.UNPROCESSABLE_ENTITY.value());
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		handleException(ex, response);
		return new ModelAndView();
	}

	private void handleException(Exception ex, HttpServletResponse response) {
		for (Entry<Class<? extends Throwable>, Integer> entry : statusCodeResolver.entrySet()) {
			if (ex.getClass().equals(entry.getKey())) {
				response.setStatus(entry.getValue());
				LOG.info("Class: {} - Message: {} - Cause: {}", ex.getClass(), ex.getMessage(), ex.getCause());
				LOG.info("Cnt", ex);
				return;
			}
		}
		/**
		 * Non managed exceptions flow Set HTTP status 500 and log the exception with a production visible level
		 */
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		LOG.warn(ex.getMessage(), ex);
	}

}
