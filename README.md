Design a calendar service that can create events for users.

Requirements:

    Users can enter their shift timings (working hours) or create busy slots. It’s possible for users to have more than one shift in a day.
    
    Users can fetch events of themselves and other users.
    
    Users can create events with other users for a defined start time and end time and delete events created by themselves.
    
    Organizer of an event can fetch the most favorable upcoming empty slot for a given set of users and a particular duration.
    
    For instance user A would like to check the favorable slot with user B, user C to set an event of 4 hours duration. This would require user A to check the upcoming events in his/her calendar as well as for user B, user C.
    
    Users can fetch events where they have conflicts for themselves for a particular day.
    
Bonus:
    
    Organizers can have the capability to create recurring events in future for a specific number of times. 
    Recurring events will have the exact same start and end time of day with the same set of users.









Possible improvements
- startTime/ endTime -> Date type instead of int / Long to store the epoch seconds


Recurring events - One way is to store each recurring event as a separate record in the database; simple but can be inefficient if lot of recurring events.

Another way to handle recurring events is to store each recurring event as a single record in the database, and then store a list of the instances of the event in a separate table. This approach is more efficient than storing each recurring event as a separate record, but it can be more complex to implement.

recurringFrequency - daily/weekly/monthly/yearly
recurringEndTime - a Date (can enforce a definite end time if no end time given by user - say 10 years down the line etc )

recurringFrequency
- cron exp
- every 1st sunday of month
every 10th day of month

We must support an infinite number of events with finite resources; behavior of our sytem-
- Recurring events are very similar to each other. Their only varying property is their date of occurrence.
- These events have a predictable difference in their date of occurrence. 
Ex: The first Monday of every month.
- They may be updated singularly(ii) or entirely(iii).
- We must return a set of recurring events for a selected date range sent to our Calendar API.

Generating events on the fly?!