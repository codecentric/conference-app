package de.codecentric.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/venueMap")
public class VenueMapController {

    @RequestMapping(method = RequestMethod.GET)
    public String venueMap(Map<String, Object> modelMap) {
        return "venueMap";
    }

}
