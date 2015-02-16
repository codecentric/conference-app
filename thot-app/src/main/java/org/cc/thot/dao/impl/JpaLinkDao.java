package org.cc.thot.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.cc.thot.dao.LinkDao;
import org.cc.thot.domain.Link;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("linkDao")
@Transactional
public class JpaLinkDao implements LinkDao {

    @PersistenceContext
    private EntityManager em;

    public JpaLinkDao() {
    }

    // test constructor
    public JpaLinkDao(EntityManager em) {
	this.em = em;
    }

    @SuppressWarnings("unchecked")
    public List<Link> getLinksBySessionId(Long sessionId) {
	Query query = em.createNamedQuery("findLinksForSession");
	return query.setParameter("sessionId", sessionId).getResultList();
    }

    public void saveLink(Link link) {
	em.merge(link);
    }
}
