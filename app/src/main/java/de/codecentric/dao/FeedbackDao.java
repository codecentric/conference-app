package de.codecentric.dao;

import java.util.List;

import de.codecentric.domain.Feedback;

public interface FeedbackDao {

    public void save(Feedback feedback);

    public List<Feedback> getFeedbackList();
}
