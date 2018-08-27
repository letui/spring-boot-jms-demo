package org.jmsdeep.converter;

import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Component;

@Component
public class DemoSnR {
	@Autowired
	JmsTemplate jmsTemplate;
	
	public void sendWithConversion() {
	    Map map = new HashMap();
	    map.put("Name", "Mark");
	    map.put("Age", new Integer(47));
	    jmsTemplate.setSessionTransacted(true);
	    jmsTemplate.convertAndSend("test.conv", map, new MessagePostProcessor() {
	        public Message postProcessMessage(Message message) throws JMSException {
	            message.setIntProperty("AccountID", 1234);
	            message.setJMSCorrelationID("123-00001");
	            return message;
	        }
	    });
	}
	@JmsListener(destination = "test.conv")
	public void receiveConv(Message msg) {
		System.out.println(msg.getClass());
		if(msg instanceof MapMessage)throw new RuntimeException("test");
		System.out.println(msg);
	}
}
