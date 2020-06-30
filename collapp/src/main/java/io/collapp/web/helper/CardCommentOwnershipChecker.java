
package io.collapp.web.helper;

import io.collapp.model.Event.EventType;
import io.collapp.model.UserWithPermission;
import io.collapp.service.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CardCommentOwnershipChecker implements OwnershipChecker {

	private final Pattern pattern = Pattern.compile("^.*/comment/(\\d+)$");

	private final EventRepository eventRepository;

	@Autowired
	public CardCommentOwnershipChecker(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	@Override
	public boolean hasOwnership(HttpServletRequest request, UserWithPermission user) {

		Matcher matcher = pattern.matcher(request.getRequestURI());
		try {
			if (matcher.matches()) {
				int commentId = Integer.parseInt(matcher.group(1), 10);
				return eventRepository.findUsersIdFor(commentId, EventType.COMMENT_CREATE).contains(user.getId());
			}
		} catch (NumberFormatException nfe) {
			return false;
		}

		return false;
	}
}
