
package io.collapp.web.api;

import io.collapp.model.CalendarInfo;
import io.collapp.model.Permission;
import io.collapp.model.UserWithPermission;
import io.collapp.service.CalendarService;
import io.collapp.service.UserRepository;
import io.collapp.service.calendarutils.CalendarEvents;
import io.collapp.web.helper.ExpectPermission;
import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Calendar;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.text.ParseException;

@RestController
public class CalendarController {

    private final UserRepository userRepository;
    private final CalendarService calendarService;

    public CalendarController(UserRepository userRepository, CalendarService calendarService) {
        this.userRepository = userRepository;
        this.calendarService = calendarService;
    }

    @ExpectPermission(Permission.UPDATE_PROFILE)
    @RequestMapping(value = "/api/calendar/disable", method = RequestMethod.POST)
    public CalendarInfo setCalendarFeedDisabled(UserWithPermission user,
        @RequestBody DisableCalendarRequest disableRequest) {
        calendarService.setCalendarFeedDisabled(user, disableRequest.isDisabled);
        return calendarService.findCalendarInfoFromUser(user);
    }

    @ExpectPermission(Permission.UPDATE_PROFILE)
    @RequestMapping(value = "/api/calendar/token", method = RequestMethod.DELETE)
    public CalendarInfo clearCalendarToken(UserWithPermission user) {
        userRepository.deleteCalendarToken(user);
        return getCalendarToken(user);
    }

    @RequestMapping(value = "/api/calendar/token", method = RequestMethod.GET)
    public CalendarInfo getCalendarToken(UserWithPermission user) {
        return calendarService.findCalendarInfoFromUser(user);
    }

    @RequestMapping(value = "/api/calendar/user", method = RequestMethod.GET)
    public CalendarEvents userStandardCalendar(UserWithPermission user) throws URISyntaxException, ParseException {
        return calendarService.getUserCalendar(user);
    }

    @RequestMapping(value = "/api/calendar/project/{projectName}", method = RequestMethod.GET)
    public CalendarEvents projectStandardCalendar(@PathVariable("projectName") String projectName, UserWithPermission user)
        throws URISyntaxException, ParseException {

        return calendarService.getProjectCalendar(projectName, user);
    }

    @RequestMapping(value = "/api/calendar/{token}/calendar.ics", method = RequestMethod.GET, produces = "text/calendar")
    public void userCalDavCalendar(@PathVariable("token") String userToken, HttpServletResponse response)
        throws IOException, URISyntaxException, ParseException {
        Calendar calendar = calendarService.getCalDavCalendar(userToken);
        response.setContentType("text/calendar");
        CalendarOutputter output = new CalendarOutputter(false); // <- no validation on the output
        try (OutputStream os = response.getOutputStream()) {
            output.output(calendar, os);
            os.flush();
        }

    }

    static class DisableCalendarRequest {
        private boolean isDisabled;

        @java.beans.ConstructorProperties({ "isDisabled" }) public DisableCalendarRequest(boolean isDisabled) {
            this.isDisabled = isDisabled;
        }
    }
}
