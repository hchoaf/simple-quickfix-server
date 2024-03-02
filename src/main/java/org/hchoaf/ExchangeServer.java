package org.hchoaf;

import org.hchoaf.core.ExchangeApplication;
import quickfix.*;

public class ExchangeServer {
    private static ThreadedSocketAcceptor acceptor;
    private static SessionSettings sessionSettings;
    private static ExchangeApplication exchangeApplication;

    ExchangeServer() {
        try {
            sessionSettings = new SessionSettings("src/main/resources/exchange.properties");
        } catch (ConfigError configError) {
            System.out.println("Warning: config error!" + configError);
        }
        exchangeApplication = new ExchangeApplication();
        MessageStoreFactory messageStoreFactory = new FileStoreFactory(sessionSettings);
        LogFactory logFactory = new FileLogFactory(sessionSettings);
        MessageFactory messageFactory = new quickfix.fix44.MessageFactory();

        try {
            acceptor = new ThreadedSocketAcceptor(exchangeApplication, messageStoreFactory, sessionSettings, logFactory, messageFactory);
        } catch (ConfigError configError) {
            System.out.println("Warning: config error! " + configError);
        }
    }

    private void start() {
        try {
            acceptor.start();
        } catch (ConfigError e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void stop() {
        acceptor.stop();
    }
    public static void main(String[] args) throws InterruptedException {
        ExchangeServer exchangeServer = new ExchangeServer();
        exchangeServer.start();
        System.out.println("Clinet Server Started");
        for(int i = 0; i<20; i++) {
            Thread.sleep(1000);
            System.out.println("Working...");
        }
        exchangeServer.stop();
    }
}