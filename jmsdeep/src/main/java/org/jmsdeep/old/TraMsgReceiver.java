package org.jmsdeep.old;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TraMsgReceiver implements MessageListener {

	@Override
	 @JmsListener(destination = "old.box", containerFactory = "myFactory")
	public void onMessage(Message message) {
		try {
			System.out.println(((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
