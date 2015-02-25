package de.codecentric.util;

import java.util.List;

import de.codecentric.domain.Session;

public class XlsSessionsToDbScript {

    /**
     * @param args
     */
    public static void main(String[] args) {
        final String filename = "src/main/resources/program.xls";
        XlsSessionsToDbScript xlsSessionsToDbScript = new XlsSessionsToDbScript();
        final List<Session> sessions = new XlsSessionReader().readAllSessions(filename);
        System.out.println("delete from session where id > " + XlsSessionReader.ID_OFFSET + ";");
        xlsSessionsToDbScript.getScriptForSession(sessions);
    }

    public void getScriptForSession(List<Session> sessions) {
        for (Session session : sessions) {
            System.out.println("insert into session (id,date,start,end,title,author,author2,description," + "location,type,authorinfo,author2info,authorimgurl,author2imgurl) values ("
                            + session.getId() + ", '" + r(session.getDate()) + "', '" + r(session.getStart()) + "', '" + r(session.getEnd()) + "', '" + r(session.getTitle()) + "', '"
                            + r(session.getAuthor()) + "', '" + r(session.getAuthor2()) + "', '" + r(session.getDescription()) + "', '" + r(session.getLocation()) + "', '"
                            + r(session.getType().toString()) + "', '" + r(session.getAuthorInfo()) + "', '" + r(session.getAuthor2Info()) + "', '" + r(session.getAuthorImgUrl()) + "', '"
                            + r(session.getAuthor2ImgUrl()) + "');");

        }
    }

    private String r(String s) {
        return s == null ? "" : s.replaceAll("\n", "<br>");
    }
}
