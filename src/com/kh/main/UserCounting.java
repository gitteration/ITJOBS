package com.kh.main;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/userCounting")
public class UserCounting {

	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());

	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		//System.out.println(message);
		synchronized (clients) {
			// Iterate over the connected sessions
			// and broadcast the received message
			
			for (Session client : clients) {
				//if (!client.equals(session)) {
					//client.getBasicRemote().sendText(message);
					client.getBasicRemote().sendText(clients.size()+","+new MainService().getTotal()+","+new MainService().getToday());
				//}
			}
		}
	}

	@OnOpen
	public void onOpen(Session session) {
		// Add session to the connected sessions set
		//System.out.println(session);
		clients.add(session);
		//System.out.println("접속자수: "+clients.size());
	}

	@OnClose
	public void onClose(Session session) throws IOException {
		// Remove session from the connected sessions set
		//System.out.println(session+"나감");
		clients.remove(session);
		//System.out.println("접속자수: "+clients.size());
		onMessage("", session);
		
	}
}
