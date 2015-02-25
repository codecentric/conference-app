package de.codecentric.domain;

import static org.mockito.Mockito.verify;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import de.codecentric.dao.impl.JpaSessionDao;

public class JpaSessionDaoTest {

    @Mock
    private EntityManager emMock;

    private JpaSessionDao dao;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        dao = new JpaSessionDao(emMock);
    }

    @Test
    public void shouldSaveSession() {
        Session session = new Session("2012/08/29", "10:00", "11:00", "Title", "Speaker", "Description");
        dao.saveSession(session);

        verify(emMock).merge(session);
    }

}
