package de.codecentric.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/appStructure")
public class AppStructureController {

    @RequestMapping(method = RequestMethod.GET)
    public String appStructure(Map<String, Object> modelMap) {
        return "appStructure";
    }

}
