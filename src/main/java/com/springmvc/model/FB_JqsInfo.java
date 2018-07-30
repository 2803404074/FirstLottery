package com.springmvc.model;

/**
 * 进球数id和赔率模型
 */
public class FB_JqsInfo {
    private String id;
    private Object current_jqs;

    public FB_JqsInfo() {
    }

    public FB_JqsInfo(String id, Object current_jqs) {
        this.id = id;
        this.current_jqs = current_jqs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getCurrent_jqs() {
        return current_jqs;
    }

    public void setCurrent_jqs(Object current_jqs) {
        this.current_jqs = current_jqs;
    }
}
