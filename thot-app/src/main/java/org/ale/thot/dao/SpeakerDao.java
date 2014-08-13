package org.ale.thot.dao;

import java.util.List;

import org.ale.thot.domain.Speaker;

public interface SpeakerDao {

	public abstract List<Speaker> getAllSpeakers();

	public abstract void createOrUpdate(Speaker speaker);

	public abstract Speaker findById(Long long1);

}