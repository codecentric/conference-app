package de.codecentric.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import de.codecentric.dao.NewsDao;
import de.codecentric.domain.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.codecentric.dao.SessionDao;
import de.codecentric.domain.Session;
import de.codecentric.util.XlsSessionReader;

@Controller
@RequestMapping("/staticSessions")
public class StaticSessionsController {

    @Autowired
    private SessionDao sessionDao;

    @Autowired
    private NewsDao newsDao;

    @RequestMapping(method = RequestMethod.GET)
    public void setupForm(ModelMap modelMap) {

        List<Session> staticSessions = sessionDao.getAllStaticSessions();
        if (staticSessions.isEmpty()) {
            // try to read the session from the xlsSheet
            XlsSessionReader xlsReader = new XlsSessionReader();
            List<Session> sessionsFromXls = xlsReader.readAllSessions();
            for (Session session : sessionsFromXls) {
                sessionDao.saveSession(session);
            }
            staticSessions = sessionDao.getAllStaticSessions();
        }

        List<News> newsList = newsDao.getAllNews();
        if (newsList.isEmpty()) {
            /*
            News n = new News();
            n.setText("<insert meaningfull news here>");
            News n2 = new News();
            n2.setText("<insert meaningfull news here - 2>");

            newsDao.saveNews(n);
            newsDao.saveNews(n2);
            */
        }

        Map<String, List<Session>> sessionsByDateMap = getStaticSessionMap(staticSessions);

        modelMap.put("sessionDays", sessionsByDateMap.keySet());
        modelMap.put("sessionMap", sessionsByDateMap);
        modelMap.put("currentSessions", sessionDao.getCurrentSessions());
        modelMap.put("newsList", newsDao.getAllNews());
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
