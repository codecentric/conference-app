package org.cc.thot.dao;

import java.util.List;

import org.cc.thot.domain.Day;
import org.cc.thot.domain.Timeslot;

public interface TimeslotDao {

    List<Timeslot> getTimeslots(String day);

    List<Day> getConferenceDays();
}
