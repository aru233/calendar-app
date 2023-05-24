package Entities;

import java.util.TreeSet;

import dao.UserIdGenerator;

public class User {
    int id;
    String name;
    TreeSet<Event> eventList;
    
    public User(String name) {
        this.id = UserIdGenerator.getInstance().getUserId();
        this.name = name;
        this.eventList = new TreeSet<>((a, b) -> a.getStartTime() == b.getStartTime() ? 
                        Integer.compare(a.getEndTime(), b.getEndTime()) : Integer.compare(a.getStartTime(), b.startTime));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public TreeSet<Event> getEventList() {
        return eventList;
    }

    public void addEventToList(Event event) {
        this.eventList.add(event);
    }

    @Override
    public String toString() {
        String temp = String.valueOf(this.id) + " " + this.name + " ";
        for(Event event : eventList) {
            temp += event.toString() + " ";
        }
        return temp;
    }
}