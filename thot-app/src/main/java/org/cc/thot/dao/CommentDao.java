package org.cc.thot.dao;

import java.util.List;

import org.cc.thot.domain.Comment;
import org.cc.thot.model.TimelineEntry;

public interface CommentDao {

    public List<Comment> getCommentsBySessionId(Long sessionId);

    public List<TimelineEntry> getRecentComments();

    public void saveComment(Comment comment);

}