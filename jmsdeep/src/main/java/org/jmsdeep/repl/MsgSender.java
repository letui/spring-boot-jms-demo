package org.jmsdeep.repl;

import org.jmsdeep.simple.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MsgSender {
	@Autowired
	private JmsTemplate jmstp;
	
	@JmsListener(destination = "server.box", containerFactory = "myFactory")
	public void responseBox(String msg) {
		System.out.println("i get your response:"+msg);
	}
	
	public void send() {
		jmstp.convertAndSend("client.box", new Email("info@example.com", "Hello").toString());
	}
}
