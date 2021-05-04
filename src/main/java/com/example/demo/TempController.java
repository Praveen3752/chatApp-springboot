package com.example.demo;

import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "https://silly-galileo-ac5ec3.netlify.app")
public class TempController 
{
	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public String sendMessage(String chatmessage)
	{
		System.out.println(chatmessage);
		return chatmessage;
	}

}
