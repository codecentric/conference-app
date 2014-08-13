package org.ale.thot.domain;

import static org.mockito.Mockito.verify;

import java.util.Date;

import javax.persistence.EntityManager;

import org.ale.thot.dao.impl.JpaCommentDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class JpaCommentDaoTest {

	@Mock
	private EntityManager emMock;
	private JpaCommentDao dao;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		dao = new JpaCommentDao(emMock);
	}
	
	@Test
	public void shouldSaveComment() {
		Comment comment = new Comment(new Date(), "me", "comment", 1L, 1);
		dao.saveComment(comment);
		verify(emMock).merge(comment);
	}
}
