package de.codecentric.dao;

import java.util.List;

import de.codecentric.domain.Link;

public interface LinkDao {

    public List<Link> getLinksBySessionId(Long sessionId);

    public void saveLink(Link link);

}