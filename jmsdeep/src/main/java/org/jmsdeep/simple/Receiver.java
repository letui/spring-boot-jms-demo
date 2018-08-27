package org.jmsdeep.simple;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(Email email) {
    	if(email==null)throw new RuntimeException("SS");
        System.out.println("Received <" + email + ">");
    }

}
