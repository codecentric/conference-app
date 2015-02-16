package org.cc.thot.dao;

import java.util.List;

import org.cc.thot.domain.Feedback;

public interface FeedbackDao {

    public void save(Feedback feedback);

    public List<Feedback> getFeedbackList();
}
