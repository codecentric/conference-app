package de.codecentric.domain;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/**
 * Domain object to represent data for a session.
 */
@Entity(name = "session")
@NamedQueries({ @NamedQuery(name = "findSessionsForDate", query = "from session where type in (:type) and date=:date"),
                @NamedQuery(name = "findListOfConferenceDays", query = "select distinct s.date from session s where s.type ='session'"),
                @NamedQuery(name = "findAllSessions", query = "from session where type is null order by date"),
                @NamedQuery(name = "findAllStaticSessions", query = "from session where type ='session' order by date"),
                @NamedQuery(name = "findStaticSessionsForDate", query = "from session where type ='session' and date=:date"),
                @NamedQuery(name = "findAllSessionsForAuthor", query = "from session where author like :author order by date") })
public class Session implements Comparable<Session> {

    public static String EMPTY_TITLE = "Available Session";
    public static String EMPTY_DESCRIPTION = "This session is still available.";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date startDate;
    private String date;
    private String start;
    private String end;

    private String title;
    private String author;
    private String author2;
    @Lob
    private String description;
    private String location;
    @Enumerated(EnumType.STRING)
    private SessionType type;
    private String authorInfo;
    private String author2Info;
    private String authorImgUrl;
    private String author2ImgUrl;

    public Session() {
    }

    public Session(String date, String startTime, String location, String title, String author, String description) {
        super();
        this.date = date;
        this.start = startTime;
        this.location = location;
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public Session(String date, String start, String end, String title, String author, String author2, String description, String location, SessionType type, String authorInfo, String author2Info,
                    String authorImgUrl, String author2ImgUrl, int id) {
        this.date = date;
        this.start = start;
        this.end = end;
        this.title = title;
        this.author = author;
        this.author2 = author2;
        this.description = description;
        this.location = location;
        this.type = type;
        this.authorInfo = authorInfo;
        this.author2Info = author2Info;
        this.authorImgUrl = authorImgUrl;
        this.author2ImgUrl = author2ImgUrl;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public String getAuthor2() {
        return author2;
    }

    public String getLocation() {
        return location;
    }

    public SessionType getType() {
        return type;
    }

    public void setType(SessionType type) {
        this.type = type;
    }

    public String getAuthorInfo() {
        return authorInfo;
    }

    public String getAuthor2Info() {
        return author2Info;
    }

    public String getAuthorImgUrl() {
        return authorImgUrl;
    }

    public String getAuthor2ImgUrl() {
        return author2ImgUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSlot(String start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "Session [title=" + title + ", author=" + author + ", description=" + description + "]";
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj instanceof Session) == false) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Session other = (Session) obj;
        return id == other.id;
    }

    public boolean isInProgress(Calendar now) {
        if (end == null) {
            return false;
        }

        int minute = now.get(Calendar.MINUTE);
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int timeIdent = hour * 100 + minute;

        int startAsInt = Integer.valueOf(start.replaceAll(":", ""));
        int endAsInt = Integer.valueOf(end.replaceAll(":", ""));

        return timeIdent >= startAsInt && timeIdent <= endAsInt;
    }

    /**
     * Method defines if session is near to be started or finished +/- 1 hour
     * 
     * @param now
     * @return true if session will start in +/- 1 hour from now
     */
    public boolean isInNearProgress(DateTime now) {
        DateTime startTime = DateTime.parse(this.date + " " + this.start, DateTimeFormat.forPattern("dd.MM.yyyy HH:mm"));
        DateTime beforeStart = now.minusHours(1);
        DateTime afterStart = now.plusHours(2);
        return ((startTime.isAfter(beforeStart) || startTime.isEqual(beforeStart)) && (startTime.isBefore(afterStart) || startTime.isEqual(afterStart)));
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int compareTo(Session session) {
        int compareByStart = compareByStart(session);
        return compareByStart == 0 ? compareByLocation(session) : compareByStart;
    }

    private int compareByLocation(Session session) {
        return compare(this.location, session.location);
    }

    private int compareByStart(Session session) {
        return compare(this.start, session.start);
    }

    private int compare(String string1, String otherString) {
        if (string1 == null) {
            return otherString == null ? 0 : -1;
        }
        return string1.compareTo(otherString);
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setSessionType(SessionType sessionType) {
        this.type = sessionType;
    }
}
