package de.codecentric.dao;

import java.util.List;

import de.codecentric.domain.Location;

public interface LocationDao {

    List<Location> getLocations();

    Location getLocation(String shortName);

}
