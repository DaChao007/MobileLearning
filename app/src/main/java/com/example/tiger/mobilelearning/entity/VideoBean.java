package com.example.tiger.mobilelearning.entity;

/**
 * Created by Tiger on 2017/12/6.
 */

public class VideoBean {

    /**
     * msg : SUCCESS
     * lastTime : 10
     * code : 200
     * url : http://192.168.3.4:8090/video/4.mp4
     */

    private String msg;
    private int lastTime;
    private int code;
    private String url;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getLastTime() {
        return lastTime;
    }

    public void setLastTime(int lastTime) {
        this.lastTime = lastTime;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
