package org.ale.thot.dao;

import java.util.List;

import org.ale.thot.domain.Comment;
import org.ale.thot.model.TimelineEntry;

public interface CommentDao {

	public List<Comment> getCommentsBySessionId(Long sessionId);
	
	public List<TimelineEntry> getRecentComments();

	public void saveComment(Comment comment);

}