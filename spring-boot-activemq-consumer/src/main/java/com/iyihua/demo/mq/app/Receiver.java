package com.iyihua.demo.mq.app;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	@JmsListener(destination = "mailbox"/*, containerFactory = "myFactory"*/)
	public void receiveMessage(String email) {
		System.out.println("Received <" + email + ">");
	}
}
