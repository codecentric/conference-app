package de.codecentric.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import de.codecentric.dao.LocationDao;
import de.codecentric.domain.Location;

@Repository
public class JsonLocationDao implements LocationDao {

    private static final Logger LOGGER = Logger.getLogger(JsonLocationDao.class);

    @Autowired
    private ObjectMapper jsonMapper;

    private static List<Location> locations;

    @Value("default.file.path.json.location:json/locations.json")
    private String filePath;

    public JsonLocationDao() {
    }

    public JsonLocationDao(ObjectMapper mapper, String filePath) {
        this.filePath = filePath;
        this.jsonMapper = mapper;
    }

    public List<Location> getLocations() {
        if (locations == null) {
            try {
                final InputStream jsonStream = this.getClass().getClassLoader().getResourceAsStream(filePath);
                if (jsonStream != null) {
                    locations = jsonMapper.readValue(jsonStream, new TypeReference<List<Location>>() {
                    });
                }
            } catch (JsonParseException e) {
                LOGGER.error("JsonParseException", e);
            } catch (IOException e) {
                LOGGER.error("IOException", e);
            }
        }
        return locations;
    }

    public Location getLocation(String shortName) {
        for (Location location : getLocations()) {
            if (shortName.endsWith(location.getShortName())) {
                return location;
            }
        }
        return null;
    }

}
