package org.cc.thot.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.cc.thot.dao.impl.JsonLocationDao;
import org.cc.thot.domain.Location;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;

public class LocationDaoTest {

    private static JsonLocationDao dao;

    @BeforeClass
    public static void setLocationDao() {
	dao = new JsonLocationDao(new ObjectMapper(), "locations.json");
    }

    @Test
    public void shouldReturnLocationCount() {
	final List<Location> locations = dao.getLocations();
	assertEquals(3, locations.size());
    }

    @Test
    public void invalidLocationShouldReturnNull() {
	assertNull(dao.getLocation("invalid"));
    }

    @Test
    public void validLocationShouldReturnLocation() {
	Location location = dao.getLocation("Room 1");
	assertEquals("Room 1", location.getShortName());
	assertEquals("Room one is located in the basement", location.getDescription());
    }

}
