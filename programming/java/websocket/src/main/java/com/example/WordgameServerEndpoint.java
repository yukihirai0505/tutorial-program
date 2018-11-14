package com.example;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/demo")
public class WordgameServerEndpoint {

    @OnMessage
    public void onMessage(String message, Session session)
            throws IOException, InterruptedException {

        // クライアントからのmessage内容をプリントアウト
        System.out.println("Received: " + message);

        // Send the first message to the client
        session.getBasicRemote().sendText("ただ今サイトオーナーに聞いてみますので、すぐに回答します。<br>");
        int sentMessages = 0;
        while (sentMessages < 2) {
            Thread.sleep(3000);
            session.getBasicRemote().
                    sendText("ただ今オンラインユーザ数は： "
                            + (sentMessages + 5) + "人です。");
            sentMessages++;
        }
        Thread.sleep(2500);
        session.getBasicRemote().sendText("新しいアクセスしてきたユーザは<b>スマホ</b>ユーザです。");

        // Send a final message to the client
        Thread.sleep(2500);
        session.getBasicRemote().sendText("<em><h3>END</h3></em><hr>");
    }

    @OnOpen
    public void onOpen() {
        System.out.println("クライアント接続した。");
    }

    @OnClose
    public void onClose() {
        System.out.println("クライアント切りました。");
    }
}
