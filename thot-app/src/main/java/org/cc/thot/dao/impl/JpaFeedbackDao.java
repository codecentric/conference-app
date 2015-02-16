package org.cc.thot.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cc.thot.dao.FeedbackDao;
import org.cc.thot.domain.Feedback;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class JpaFeedbackDao implements FeedbackDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Feedback feedback) {
	em.merge(feedback);
    }

    @Override
    public List<Feedback> getFeedbackList() {
	return em.createNamedQuery("findFeedback", Feedback.class).getResultList();
    }

}
