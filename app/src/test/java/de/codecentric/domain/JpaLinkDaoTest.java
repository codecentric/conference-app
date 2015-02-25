package de.codecentric.domain;

import static org.mockito.Mockito.verify;

import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import de.codecentric.dao.impl.JpaLinkDao;
import de.codecentric.domain.Link;

public class JpaLinkDaoTest {

    @Mock
    private EntityManager emMock;
    private JpaLinkDao dao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        dao = new JpaLinkDao(emMock);
    }

    @Test
    public void shouldSaveLink() {
        Link link = new Link();
        link.setComment("comment");
        link.setDate(new Date());
        link.setLink("www.google.de");
        link.setSessionId(1L);
        dao.saveLink(link);
        verify(emMock).merge(link);
    }
}
