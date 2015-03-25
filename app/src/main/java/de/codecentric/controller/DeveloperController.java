package de.codecentric.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.codecentric.dao.DeveloperRepository;

@Controller
@RequestMapping("/developer")
public class DeveloperController {

    private static final Logger LOGGER = Logger.getLogger(DeveloperController.class);

    @Autowired
    private DeveloperRepository repository;
    
    @RequestMapping(method = RequestMethod.GET)
    public String listDeveloper(Map<String, Object> modelMap) {
        LOGGER.info("listDeveloper " + repository.count());
        
        modelMap.put("developerList", repository.findAll());
        return "developer";
    }

}
