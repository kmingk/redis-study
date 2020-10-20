package com.yzm.redis.tuski;

import net.bytebuddy.dynamic.scaffold.MethodGraph;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

public class bulletChat implements Serializable {

    public static final long serialVersionUID = 212199624406986608L;
    private String content;
    private String color;
    private int score;

    private int likeNumber;
    private Set<String> likePlayers = new LinkedHashSet<>();

    private BulletChatType bulletChatType;
    private int startTime;
    private int endTime;
    private int position;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(int likeNumber) {
        this.likeNumber = likeNumber;
    }

    public Set<String> getLikePlayers() {
        return likePlayers;
    }

    public void setLikePlayers(Set<String> likePlayers) {
        this.likePlayers = likePlayers;
    }

    public BulletChatType getBulletChatType() {
        return bulletChatType;
    }

    public void setBulletChatType(BulletChatType bulletChatType) {
        this.bulletChatType = bulletChatType;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public static void main(String[] args) throws Exception{
        File file = new File("D:/bulletcaht.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for (int i = 0; i < 1000; i++) {
            bulletChat bulletChat = getBulletChat();
            objectOutputStream.writeObject(bulletChat);
            objectOutputStream.flush();
        }
        objectOutputStream.close();
        fileOutputStream.close();

    }

    public static bulletChat getBulletChat() {
        bulletChat bulletChat = new bulletChat();
        bulletChat.setBulletChatType(BulletChatType.FIXED);
        bulletChat.setColor("aaaaaaaa");
        bulletChat.setStartTime(2);
        bulletChat.setEndTime(4);
        bulletChat.setScore(23);
        bulletChat.setLikeNumber(22);

        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < 22; i++) {
            set.add("player_" + i);
        }

        bulletChat.setLikePlayers(set);

        return bulletChat;
    }

}
