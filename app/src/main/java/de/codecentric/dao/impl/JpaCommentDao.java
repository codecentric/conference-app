package de.codecentric.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.codecentric.dao.CommentDao;
import de.codecentric.domain.Comment;
import de.codecentric.model.TimelineEntry;

@Repository("commentDao")
@Transactional
public class JpaCommentDao implements CommentDao {

    @PersistenceContext
    private EntityManager em;

    public JpaCommentDao() {
    }

    // test constructor
    public JpaCommentDao(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    public List<Comment> getCommentsBySessionId(Long sessionId) {
        Query query = em.createNamedQuery("findCommentForSession");
        return query.setParameter("sessionId", sessionId).getResultList();
    }

    public List<TimelineEntry> getRecentComments() {
        List<TimelineEntry> result = new ArrayList<TimelineEntry>();

        @SuppressWarnings("unchecked")
        List<Object[]> resultList = em.createNamedQuery("findRecentComments").setMaxResults(25).getResultList();

        for (Object[] entry : resultList) {
            result.add(new TimelineEntry(entry[0] != null ? entry[0].toString() : "", entry[0] != null ? entry[1].toString() : "", entry[0] != null ? entry[2].toString() : "",
                            entry[0] != null ? entry[3].toString() : "", entry[0] != null ? entry[4].toString() : ""));
        }

        return result;
    }

    public void saveComment(Comment comment) {
        em.merge(comment);
    }

}
