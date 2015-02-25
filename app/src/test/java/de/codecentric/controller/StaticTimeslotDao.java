package de.codecentric.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.codecentric.dao.TimeslotDao;
import de.codecentric.domain.Day;
import de.codecentric.domain.Timeslot;

public class StaticTimeslotDao implements TimeslotDao {

    private Map<String, List<Timeslot>> timeslotsPerDay;
    private ArrayList<Day> days;
    private String[] dayNames = { "Wed", "Thu", "Fri" };

    public StaticTimeslotDao() {
        initializeDays();

        Map<String, String[]> daysAndTimeslots = new HashMap<String, String[]>();
        daysAndTimeslots.put("Wed", new String[] { "15:30", "16:15", "Evening" });
        daysAndTimeslots.put("Thu", new String[] { "15:30", "16:15", "17:00", "Evening" });
        daysAndTimeslots.put("Fri", new String[] { "11:30", "12:15" });

        timeslotsPerDay = new HashMap<String, List<Timeslot>>();

        List<Timeslot> wedTimeSlots = new ArrayList<Timeslot>();
        wedTimeSlots.add(new Timeslot("15:30", "16:15"));
        wedTimeSlots.add(new Timeslot("16:15", "17:00"));
        wedTimeSlots.add(new Timeslot("Evening"));

        List<Timeslot> thuTimeSlots = new ArrayList<Timeslot>();
        thuTimeSlots.add(new Timeslot("15:30", "16:15"));
        thuTimeSlots.add(new Timeslot("16:15", "17:00"));
        thuTimeSlots.add(new Timeslot("17:00", "17:45"));
        thuTimeSlots.add(new Timeslot("Evening"));

        List<Timeslot> friTimeSlots = new ArrayList<Timeslot>();
        friTimeSlots.add(new Timeslot("11:30 - 12:10"));
        friTimeSlots.add(new Timeslot("12:15 - 13:00"));

        timeslotsPerDay.put("Wed", wedTimeSlots);
        timeslotsPerDay.put("Thu", thuTimeSlots);
        timeslotsPerDay.put("Fri", friTimeSlots);
    }

    public List<Timeslot> getTimeslots(String day) {

        return timeslotsPerDay.get(day);
    }

    public List<Day> getConferenceDays() {

        return days;
    }

    private void initializeDays() {
        days = new ArrayList<Day>();

        for (String dayName : dayNames) {
            days.add(new Day(dayName, null));
        }
    }

}
