package de.codecentric.dao.impl;

import de.codecentric.dao.NewsDao;
import de.codecentric.domain.News;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("newsDao")
@Transactional
public class JpaNewsDao implements NewsDao {

    @PersistenceContext
    private EntityManager em;

    public JpaNewsDao() {
        // default constructor
    }

    // Test constructor
    public JpaNewsDao(EntityManager em) {
        this.em = em;
    }

    @Override public List<News> getAllNews() {
        return em.createNamedQuery("findAllNews", News.class).getResultList();
    }

    @Override public void saveNews(News n) {
        em.merge(n);
    }

}
