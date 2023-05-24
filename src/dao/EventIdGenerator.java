package dao;

public class EventIdGenerator {
    private static EventIdGenerator eventIdGenerator = new EventIdGenerator();
    private int eventId = 1;

    public static EventIdGenerator getInstance(){
        if(eventIdGenerator == null){
            eventIdGenerator = new EventIdGenerator();
        }
        return eventIdGenerator;
    }

    public int getEventId(){
        return eventId++;
    }
    
}