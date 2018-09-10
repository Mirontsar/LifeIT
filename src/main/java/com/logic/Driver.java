package com.logic;

import com.messageObj.DispatchedType;
import com.messageObj.MessageType;

import javax.xml.bind.JAXBException;

import static com.messageObj.MessageType.getMsgObject;

public class Driver extends Thread {

    private MessageType msg;
    private Integer event;

    public Driver(MessageType msg, Integer event) {
        this.msg = msg;
        this.event = event;
    }

    @Override
    public void run() {
        try {
            msg.setDispatched(new DispatchedType());
            msg.getDispatched().setId(event);
            getMsgObject(msg);
            sleep(3000);
        } catch (InterruptedException | JAXBException e) {
            e.printStackTrace();
        }
    }
}
