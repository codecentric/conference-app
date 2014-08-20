package org.ale.thot.dao;

import java.util.List;

import org.ale.thot.domain.Feedback;

public interface FeedbackDao {

	public void save(Feedback feedback);
	public List<Feedback> getFeedbackList();
}
