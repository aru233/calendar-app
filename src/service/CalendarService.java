package service;

import java.util.ArrayList;
import java.util.List;

import Entities.Event;
import Entities.User;

public class CalendarService {

    public int createEvent(int startTime, int endTime, User creator, List<User> guestList) {
        //Builder pattern
        Event event = new Event.EventBuilder()
                .withStartTime(startTime)
                .withEndTime(endTime)
                .withCreator(creator)
                .withGuestList(guestList)
                .build();

        for(User guest : guestList) {
            guest.addEventToList(event);
        }

        return event.getId();
    }

    public boolean deleteEvent(User user, int eventId) {
        Event eventToDelete = null;

        for(Event event : user.getEventList()){
            if(event.getId() == eventId) {
                eventToDelete = event;
                break;
            }
        }

        if(eventToDelete == null) {
            System.out.println("EventId does not exist");//Define custom exception
            return false;
        }

        user.getEventList().remove(eventToDelete);
        return true;
    }

    public int fetchFavorableStartTime(int duration, List<User> guestList) {
        int[] hourlyTimeMap = new int[25];

        for(User user : guestList) {
            for(Event event : user.getEventList()) {
                hourlyTimeMap[event.getStartTime() - 1] += 1;
                hourlyTimeMap[event.getEndTime()] -= 1;
            }
        }

        for(int i = 1; i <= 24; i++) {
            hourlyTimeMap[i] += hourlyTimeMap[i - 1];
        }

        int startTime;
        for(int i = 0; i <= 24; i++) {
            int countFree = 0;
            startTime = i;
            while(i <= 24 && hourlyTimeMap[i] == 0 ) {
                countFree++;
                i++;
            }
            if(countFree >= duration) return startTime;
        }

        System.out.println("No free slot for this duration");//define custom exception
        return -1;
    }

    public List<Integer> getConflictinEvents(User user) {

        int[] hourlyTimeMap = new int[25];

        for(Event event : user.getEventList()) {
            hourlyTimeMap[event.getStartTime() - 1] += 1;
            hourlyTimeMap[event.getEndTime()] -= 1;
        }

        for(int i = 1; i <= 24; i++) {
            hourlyTimeMap[i] += hourlyTimeMap[i - 1];
        }

        List<Integer> conflictList = new ArrayList<>(); // can return whole events too
        for(int i = 0; i <= 24; i++) {
            if(hourlyTimeMap[i] > 1) {
                conflictList.add(i);
            }
        }

        return conflictList;
    }
}
