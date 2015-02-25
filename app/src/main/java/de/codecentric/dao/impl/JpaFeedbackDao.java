package de.codecentric.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.codecentric.dao.FeedbackDao;
import de.codecentric.domain.Feedback;

@Transactional
@Repository
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
