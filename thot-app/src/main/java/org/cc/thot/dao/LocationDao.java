package org.cc.thot.dao;

import java.util.List;

import org.cc.thot.domain.Location;

public interface LocationDao {

    List<Location> getLocations();

    Location getLocation(String shortName);

}
