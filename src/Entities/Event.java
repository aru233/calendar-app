package Entities;

import java.util.List;

import dao.EventIdGenerator;

public class Event {

    int id;
    int startTime;
    int endTime;
    int recurringFrequency;
    int recurringEndTime;
    User creator;
    List<User> guestList;


    private Event(EventBuilder builder) {
        this.id = EventIdGenerator.getInstance().getEventId();
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.recurringEndTime = builder.recurringEndTime;
        this.recurringFrequency = builder.recurringFrequency;
        this.creator = builder.creator;
        this.guestList = builder.guestList;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getStartTime() {
        return startTime;
    }
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }
    public int getEndTime() {
        return endTime;
    }
    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
    public int getRecurringFrequency() {
        return recurringFrequency;
    }
    public void setRecurringFrequency(int recurringFrequency) {
        this.recurringFrequency = recurringFrequency;
    }
    public int getRecurringEndTime() {
        return recurringEndTime;
    }
    public void setRecurringEndTime(int recurringEndTime) {
        this.recurringEndTime = recurringEndTime;
    }
    public User getCreator() {
        return creator;
    }
    public void setCreator(User creator) {
        this.creator = creator;
    }
    public List<User> getGuestList() {
        return guestList;
    }
    public void setGuestList(List<User> guestList) {
        this.guestList = guestList;
    }

    @Override
    public String toString() {
        return String.valueOf(this.id);
    }

    public static class EventBuilder {
        int id;
        int startTime;
        int endTime;
        int recurringFrequency;
        int recurringEndTime;
        User creator;
        List<User> guestList;

        public EventBuilder() {

        }

        public EventBuilder withStartTime(int startTime) {
            this.startTime = startTime;
            return this;
        }
        public EventBuilder withEndTime(int endTime) {
            this.endTime = endTime;
            return this;
        }
        public EventBuilder withRecurringFrequency(int recurringFrequency) {
            this.recurringFrequency = recurringFrequency;
            return this;
        }
        public EventBuilder withRecurringEndTime(int recurringEndTime) {
            this.recurringEndTime = recurringEndTime;
            return this;
        }
        public EventBuilder withCreator(User creator) {
            this.creator = creator;
            return this;
        }
        public EventBuilder withGuestList(List<User> guestList) {
            this.guestList = guestList;
            return this;
        }

        public Event build() {
            return new Event(this);
        }

    }

}
