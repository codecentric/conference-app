package de.codecentric.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import de.codecentric.dao.NewsDao;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.codecentric.dao.SessionDao;
import de.codecentric.domain.Session;
import de.codecentric.domain.SessionType;

@Controller
@RequestMapping("/currentSessions")
public class CurrentSessionsController {

    @Autowired
    private SessionDao sessionDao;

    @Autowired
    private NewsDao newsDao;

    @RequestMapping(method = RequestMethod.GET)
    public void setupForm(ModelMap modelMap) {

        List<Session> staticSessions = sessionDao.getAllSessions();
        Map<String, List<Session>> sessionsByDateMap = getStaticSessionMap(staticSessions);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        String now = format.format(new Date());

        List<Session> allSessionsByDate = sessionDao.getAllSessionsByDateAndType(now, SessionType.openspace, SessionType.session);
        modelMap.put("currentSessions", filterCurrentSessions(allSessionsByDate));
        modelMap.put("sessionDays", sessionsByDateMap.keySet());
        modelMap.put("sessionMap", sessionsByDateMap);
        modelMap.put("newsList", newsDao.getAllNews());
    }

    private List<Session> filterCurrentSessions(List<Session> allSessionsByDate) {
        List<Session> result = new ArrayList<Session>();
        for (Session session : allSessionsByDate) {
            if (session.isInNearProgress(DateTime.now())) {
                result.add(session);
            }
        }
        return result;
    }

    private Map<String, List<Session>> getStaticSessionMap(List<Session> staticSessions) {
        Map<String, List<Session>> sessionsByDateMap = new TreeMap<String, List<Session>>();

        for (Session session : staticSessions) {
            String key = session.getDate();
            List<Session> list;
            if (sessionsByDateMap.containsKey(key)) {
                list = sessionsByDateMap.get(key);
                list.add(session);
            } else {
                list = new ArrayList<Session>();
                list.add(session);
                sessionsByDateMap.put(key, list);
            }
        }
        return sessionsByDateMap;
    }

}
