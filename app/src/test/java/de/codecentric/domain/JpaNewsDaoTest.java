package de.codecentric.domain;

import de.codecentric.dao.impl.JpaNewsDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityManager;

import static org.mockito.Mockito.verify;

public class JpaNewsDaoTest {

    @Mock
    private EntityManager emMock;
    private JpaNewsDao dao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        dao = new JpaNewsDao(emMock);
    }

    @Test
    public void shouldSaveNews() {
        News news = new News();
        dao.saveNews(news);
        verify(emMock).merge(news);
    }
}
