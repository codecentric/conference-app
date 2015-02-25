package de.codecentric.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/changelog")
public class ChangelogController {

    @RequestMapping(method = RequestMethod.GET)
    public String changelog(Map<String, Object> modelMap) {
        return "changelog";
    }

}
