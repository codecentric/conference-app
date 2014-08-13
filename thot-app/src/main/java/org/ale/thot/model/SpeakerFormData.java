package org.ale.thot.model;

import org.ale.thot.domain.Speaker;
import org.springframework.util.StringUtils;

public class SpeakerFormData {

	private String id;

	private String foreName;
	private String lastName;
	private String bio;
	private String mail;

	public SpeakerFormData(Speaker speaker) {
		id = String.valueOf(speaker.getId());
		foreName = speaker.getForeName();
		lastName = speaker.getLastName();
		bio = speaker.getBio();
		mail = speaker.getMail();
	}

	public SpeakerFormData() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getForeName() {
		return foreName;
	}

	public void setForeName(String foreName) {
		this.foreName = foreName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Speaker toSpeaker() {
		Speaker speaker = new Speaker();
		speaker.setBio(getBio());
		speaker.setMail(getMail());
		speaker.setForeName(getForeName());
		speaker.setLastName(getLastName());
		if (!idEmpty()) {
			speaker.setId(new Long(getId()));
		}
		return speaker;
	}

	private boolean idEmpty() {
		return !StringUtils.hasText(getId());
	}

	public boolean getSpeakerExisting() {
		return !idEmpty();
	}
}
