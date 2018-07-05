package com.neo.drools.entity;

import java.util.Date;

public class AutoMessage {

    //true:启用则自动发消息；false：不启用不发送消息
    private Boolean state;

    //游戏id
    private Long gameId;

    //用户id
    private Long userId;

    //上次发送消息的时间
    private Long lastSendDate;

    //上次登录时间
    private Long lastLoginDate;

    //本次是否发送
    private Boolean send;

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getLastSendDate() {
        return lastSendDate;
    }

    public void setLastSendDate(Long lastSendDate) {
        this.lastSendDate = lastSendDate;
    }

    public Long getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Long lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Boolean getSend() {
        return send;
    }

    public void setSend(Boolean send) {
        this.send = send;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}