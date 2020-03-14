package com.kh.main;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class VisitorSessionListener implements HttpSessionListener {
	
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		HttpSession session = sessionEvent.getSession();
		System.out.println("sessionCreated : "+session.isNew());
		if(session.isNew()) {
			new MainService().visit();
		}
		//session.setAttribute("totalVisitCount", new MainService().getTotal());
		//session.setAttribute("todayVisitCount", new MainService().getToday());
		//System.out.println(session.getId());
	}
	
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		System.out.println("세션 종료");
	}
}
