package org.ale;

import java.util.List;

import org.ale.app.XlsSessionReader;
import org.ale.thot.domain.Session;

public class XlsSessionsToDbScript {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("please specify file name");
		} else {
			final String filename = args[1];
			XlsSessionsToDbScript xlsSessionsToDbScript = new XlsSessionsToDbScript();
			final List<Session> sessions = new XlsSessionReader().readAllSessions(filename);	
			System.out.println("delete from session where id > " + XlsSessionReader.ID_OFFSET + ";");
			xlsSessionsToDbScript.getScriptForSession(sessions);
		}

	}
	
	public void getScriptForSession(List<Session> sessions) {
	  for (Session session : sessions) {
		  System.out.println("insert into session (id,date,start,end,title,author,author2,description," +
	           "location,type,authorinfo,author2info,authorimgurl,author2imgurl) values (" +
				session.getId()  + ", '" +
				r(session.getDate()) + "', '" +
				r(session.getStart()) + "', '" +
				r(session.getEnd()) + "', '" +
				r(session.getTitle()) + "', '" +
				r(session.getAuthor()) + "', '" +
				r(session.getAuthor2())  + "', '" +
				r(session.getDescription()) + "', '" +
				r(session.getLocation()) + "', '" +
				r(session.getType()) + "', '" +
				r(session.getAuthorInfo()) + "', '" +
				r(session.getAuthor2Info()) + "', '" +
				r(session.getAuthorImgUrl()) + "', '" +
				r(session.getAuthor2ImgUrl()) + "');"
			);

	   }
	}
	
	private String r(String s) {
		return s == null ? "" : s.replaceAll("\n", "<br>");
	}
}
