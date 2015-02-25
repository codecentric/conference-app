package de.codecentric.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/twitterWall")
public class TwitterWallController {

    @RequestMapping(method = RequestMethod.GET)
    public String twitterWall(Map<String, Object> modelMap) {
        return "twitterWall";
    }

}
