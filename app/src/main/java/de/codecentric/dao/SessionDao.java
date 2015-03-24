package de.codecentric.dao;

import java.util.List;

import de.codecentric.domain.Session;
import de.codecentric.domain.SessionType;

/**
 * DAO to handle {@link Session} related stuff.
 */
public interface SessionDao {

    List<Session> getAllSessions();

    List<String> getListOfConferenceDays();

    List<Session> getAllStaticSessions();

    /* returns all sessions for a specific date */
    List<Session> getSessionsByDate(String date);

    Session saveSession(Session session);

    Session getSessionById(String id);

    List<Session> getStaticSessionsByDate(String shortName);

    List<Session> getCurrentSessions();

    List<Session> getAllSessionsByAuthor(String author);

    List<Session> getAllSessionsByDate(String now);

    List<Session> getAllSessionsByDateAndType(String date, SessionType... type);

    List<Session> getAllSessionsByAuthorOrTitleOrDescription(String searchTerm);

}
