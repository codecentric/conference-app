package org.ale.thot.dao;

import java.util.List;

import org.ale.thot.domain.Location;

public interface LocationDao {

    List<Location> getLocations();

    Location getLocation(String shortName);

}
