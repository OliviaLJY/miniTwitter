//package com.example.zhitongguigu.websocket;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import javax.websocket.*;
//import javax.websocket.server.PathParam;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//import java.util.HashMap;
//
//
//@Component
//@ServerEndpoint("/ws/{token}")
//public class WebSocketServer {
//    // http://localhost:8085
//    // ws:/localhost:8085/ws/abc
//
//    private String token = "";
//
//    private static final Logger LOG = LoggerFactory.getLogger(WebSocketServer.class);
//    private static HashMap<String, Session> map = new HashMap<>();
//
//    @OnOpen
//    public void onOpen(Session session, @PathParam("token") String token){
//        map.put(token, session);
//        // LOG
//        LOG.info("New Connection has been established, token: {}, session : {}, current connection count {}",
//                token, session.getId(), map.size());
//    }
//
//    @OnClose
//    public void onClose(Session session){
//        map.remove(this.token);
//        LOG.info("Connection closed, token: {}, session id: {}", this.token, session.getId());
//    }
//
//    public void sendInfoToAllSessions(String message){
//        for(String token : map.keySet()){
//            Session session = map.get(token);
//
//            try {
//                session.getBasicRemote().sendText(message);
//                LOG.info("Message sent successfully to session: {}, message: {}", session.getId(), message);
//            } catch (IOException ex) {
//                LOG.error("Failed to push message: {} to session: {}", message, session.getId());
//            }
//        }
//    }
//
//    @OnError
//    public void onError(Session session, Throwable err){
//        LOG.error("Connection err", err);
//    }
//
//    @OnMessage
//    public void onMessage(String message, Session session) {
//        LOG.info("Message received: {} from session: {}", message, session.getId());
//    }
//}
