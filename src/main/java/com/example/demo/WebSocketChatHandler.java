package com.example.demo;

import java.awt.font.TextMeasurer;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
@Component
public class WebSocketChatHandler extends TextWebSocketHandler 
{
	private final List<WebSocketSession> sessionList = new ArrayList<>();

	//TextMessage mm = new TextMessage(null);
	List<TextMessage> msgList = new ArrayList<>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception
	{
		sessionList.add(session);
		//session.sendMessage("hello");
		for(int i=0;i<msgList.size();i++)
		{
			session.sendMessage(msgList.get(i));
		}
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception
	{
		System.out.println(message.toString());
		System.out.println(message.getPayload());
		for(WebSocketSession tempsession : sessionList)
		{
			tempsession.sendMessage(message);
		}
		msgList.add(message);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception 
	{
		sessionList.remove(session);
	}

	
}
