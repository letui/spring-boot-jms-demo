package org.jmsdeep.repl;

import java.util.UUID;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
@Component
public class MsgReceiver {

	@JmsListener(destination = "client.box", containerFactory = "myFactory")
	@SendTo("server.box")
	public String inputBox(String msg) {
		String uuid=UUID.randomUUID().toString();
		System.out.println(msg+" i get u ,i'm "+uuid);
		return "this is auto reply,from "+uuid;
	}
}
