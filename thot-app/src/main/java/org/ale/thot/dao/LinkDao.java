package org.ale.thot.dao;

import java.util.List;

import org.ale.thot.domain.Link;

public interface LinkDao {

    public List<Link> getLinksBySessionId(Long sessionId);

    public void saveLink(Link link);

}