package org.ale.thot.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ale.app.XlsSessionReader;
import org.ale.thot.dao.SessionDao;
import org.ale.thot.domain.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/staticSessions")
public class StaticSessionsController {

	@Autowired
	private SessionDao sessionDao;

	@RequestMapping(method = RequestMethod.GET)
	public void setupForm(ModelMap modelMap) {
		
		List<Session>staticSessions = sessionDao.getAllStaticSessions();
		if(staticSessions.isEmpty()) {
			// try to read the session from the xlsSheet
			XlsSessionReader xlsReader = new XlsSessionReader(); 
			List<Session> sessionsFromXls = xlsReader.readAllSessions();
			for (Session session : sessionsFromXls) {
				sessionDao.saveSession(session);
			}
			staticSessions = sessionDao.getAllStaticSessions();
		}

		Map<String, List<Session>> sessionsByDateMap = getStaticSessionMap(staticSessions);
		sortSessionsByDateAndLocation(sessionsByDateMap);
		
		modelMap.put("sessionDays", sessionDao.getListOfConferenceDays());
		modelMap.put("sessionMap", sessionsByDateMap );
		modelMap.put("currentSessions", sessionDao.getCurrentSessions());
	}

	private Map<String, List<Session>> getStaticSessionMap(
			List<Session> staticSessions) {
		Map<String, List<Session>> sessionsByDateMap = new HashMap<String, List<Session>>();
		for (Session session : staticSessions) {
			String key = session.getDate();
			List<Session> list;
			if( sessionsByDateMap.containsKey( key ) ) {
				list = sessionsByDateMap.get( key );
				list.add( session );
			} else {
				list = new ArrayList<Session>();
				list.add( session );
			}
			sessionsByDateMap.put(key, list);
		}
		return sessionsByDateMap;
	}

	private void sortSessionsByDateAndLocation(Map<String, List<Session>> sessionsByDateMap) {
	    Set<String> keySet = sessionsByDateMap.keySet();
        for (String date : keySet) {
            List<Session> sessions = sessionsByDateMap.get(date);
            // Collections.sort(sessions);
            sessionsByDateMap.put(date, sessions);
            
        }
    }
}
