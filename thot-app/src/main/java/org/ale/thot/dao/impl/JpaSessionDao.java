package org.ale.thot.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.ale.thot.dao.SessionDao;
import org.ale.thot.domain.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("sessionDao")
@Transactional
public class JpaSessionDao implements SessionDao {

	@PersistenceContext
	private EntityManager em;
	
	public JpaSessionDao() { }
	
	// test constructor
	public JpaSessionDao(EntityManager em) {
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	public List<Session> getSessionsByDate(String date) {
		Query query = em.createNamedQuery("findSessionsForDate");
		return query.setParameter("date", date).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Session> getAllSessions() {
		return em.createNamedQuery("findAllSessions").getResultList();
	}
	
	public void saveSession(Session session) {
		em.merge(session);
	}

	public Session getSessionById(String id) {
		return em.find(Session.class, Long.parseLong(id));
	}

	@SuppressWarnings("unchecked")
	public List<Session> getAllStaticSessions() {
		return em.createNamedQuery("findAllStaticSessions").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Session> getStaticSessionsByDate(String date) {
		Query query = em.createNamedQuery("findStaticSessionsForDate");
		return query.setParameter("date", date).getResultList();
	}

	public List<Session> getCurrentSessions() {
		List<Session> todaySessions = getStaticSessionsByDate(getNowAsString());
		List<Session> currentSessions = new ArrayList<Session>();
		for (Session session : todaySessions) {
			if(session.isInProgress(Calendar.getInstance())){
				currentSessions.add(session);
			}
		}
		
		return currentSessions;
	}

	String getNowAsString() {
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		return format.format(new Date());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<String> getListOfConferenceDays() {
		Query query = em.createNamedQuery("findListOfConferenceDays");
		return query.getResultList();
	}
	
}
