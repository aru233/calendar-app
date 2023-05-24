import java.util.ArrayList;
import java.util.List;

import Entities.Event;
import Entities.User;
import service.CalendarService;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        User user1 = new User("User1");
        User user2 = new User("User2");
        User user3 = new User("User3");

        List<User> userList1 = new ArrayList<>();
        userList1.add(user1);
        userList1.add(user2);
        

        // Create Event
        CalendarService calendarService = new CalendarService();
        int eventId = calendarService.createEvent(1, 2, user1, userList1);
        System.out.println("New event id: " + eventId);

        System.out.println("User1's Event List");
        for(Event event : user1.getEventList()) {
            System.out.println("Event Id: " + String.valueOf(event.getId()));
        }

        System.out.println("User2's Event List");
        for(Event event : user2.getEventList()) {
            System.out.println("Event Id: " + String.valueOf(event.getId()));
        }


        // Delete event
        System.out.println("Event deleted: " + calendarService.deleteEvent(user1, 1));

        System.out.println("User1's Event List after deletion");
        for(Event event : user1.getEventList()) {
            System.out.println("Event Id: " + String.valueOf(event.getId()));
        }


        // Find favorable slot
        System.out.println("Favorable start time: " + calendarService.fetchFavorableStartTime(1, userList1));


        // Find conflicts
        System.out.println("Conflicting start times slots: " + calendarService.getConflictinEvents(user3));
    }
}
