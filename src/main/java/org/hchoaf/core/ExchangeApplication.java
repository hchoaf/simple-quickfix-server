package org.hchoaf.core;

import quickfix.*;
import quickfix.fix44.NewOrderSingle;

public class ExchangeApplication extends quickfix.fix44.MessageCracker implements Application {
    @Override
    public void onCreate(SessionID sessionId) {
        System.out.println("onCreate");
    }

    @Override
    public void onLogon(SessionID sessionId) {
        System.out.println("onLogon");

    }

    @Override
    public void onLogout(SessionID sessionId) {
        System.out.println("onLogout");

    }

    @Override
    public void toAdmin(Message message, SessionID sessionId) {
        System.out.println("toAdmin");

    }

    @Override
    public void fromAdmin(Message message, SessionID sessionId) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        System.out.println("fromAdmin");

    }

    @Override
    public void toApp(Message message, SessionID sessionId) throws DoNotSend {

    }

    @Override
    public void fromApp(Message message, SessionID sessionId) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {

    }

    public void onMessage(NewOrderSingle newOrderSingle, SessionID sessionID)
        throws FieldNotFound {
        System.out.printf("Received New Order Single %s \n", newOrderSingle.toString());
    }
}
