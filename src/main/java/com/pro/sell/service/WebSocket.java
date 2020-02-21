package com.pro.sell.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Maktub
 * @Date 2020/2/21 11:30
 */

@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class WebSocket {
    private Session session;

    private static CopyOnWriteArrayList<WebSocket> webSockets = new CopyOnWriteArrayList<>();

    @OnOpen
    public void onOpen(Session session){
       this.session = session;
       webSockets.add(this);
       log.info("【webSocket消息】有新连接,总数：{}", webSockets.size());
    }

    @OnClose
    public void onClose(){
        webSockets.remove(this);
        log.info("【webSocket消息】有连接断开,总数：{}", webSockets.size());
    }

    @OnMessage
    public void onMessage(String message){
        log.info("【webSocket消息】收到客户端发送的消息：{}", message);
    }

    public void sendMessage(String message){
        webSockets.forEach(webSocket -> {
            log.info("【webSocket消息】message = {}", message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
