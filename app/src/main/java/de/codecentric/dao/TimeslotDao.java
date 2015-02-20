package de.codecentric.dao;

import java.util.List;

import de.codecentric.domain.Day;
import de.codecentric.domain.Timeslot;

public interface TimeslotDao {

    List<Timeslot> getTimeslots(String day);

    List<Day> getConferenceDays();
}
