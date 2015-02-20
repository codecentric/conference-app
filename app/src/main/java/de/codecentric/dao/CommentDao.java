package de.codecentric.dao;

import java.util.List;

import de.codecentric.domain.Comment;
import de.codecentric.model.TimelineEntry;

public interface CommentDao {

    public List<Comment> getCommentsBySessionId(Long sessionId);

    public List<TimelineEntry> getRecentComments();

    public void saveComment(Comment comment);

}