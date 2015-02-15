package org.ale.thot.dao;

import java.util.List;

import org.ale.thot.domain.Day;
import org.ale.thot.domain.Timeslot;

public interface TimeslotDao {

    List<Timeslot> getTimeslots(String day);

    List<Day> getConferenceDays();
}
