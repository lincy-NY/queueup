package xyz.lincy.queueup.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/queueUp")
@Component
@Slf4j
public class QueueUpEndpoint {

    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<>());


    @OnOpen
    public void onOpen(Session session){
        System.out.println("Client connect");
        sessions.add(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Client Message: " + message);
        sendMessageToAll(session.getId() + ": " + message);
    }
    @OnClose
    public void onClose(Session session) {
        System.out.println("Connection Closed");
        sessions.remove(session);
    }
    @OnError
    public void onError(Throwable error) {
        System.out.println("Error Occurred");
    }
    private static void sendMessageToAll(String message) {
        for (Session session : sessions) {
//            sendMessage(session, message);
        }
    }
}
