package de.codecentric.controller;

import java.util.Map;

import de.codecentric.dao.NewsDao;
import de.codecentric.dao.impl.JpaNewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/venueMap")
public class VenueMapController {

    @Autowired
    private NewsDao newsDao;

    @RequestMapping(method = RequestMethod.GET)
    public String venueMap(Map<String, Object> modelMap) {
        modelMap.put("newsList", newsDao.getAllNews());
        return "venueMap";
    }

}
