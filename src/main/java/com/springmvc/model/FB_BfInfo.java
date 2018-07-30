package com.springmvc.model;

/**
 * 比分id和赔率模型
 */
public class FB_BfInfo {
    private String id;
    private Object current_bf;

    public FB_BfInfo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getCurrent_bf() {
        return current_bf;
    }

    public void setCurrent_bf(Object current_bf) {
        this.current_bf = current_bf;
    }
}
