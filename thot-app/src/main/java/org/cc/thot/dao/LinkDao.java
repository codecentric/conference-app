package org.cc.thot.dao;

import java.util.List;

import org.cc.thot.domain.Link;

public interface LinkDao {

    public List<Link> getLinksBySessionId(Long sessionId);

    public void saveLink(Link link);

}