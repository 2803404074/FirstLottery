package com.springmvc.model;

/**
 * 半全场id和赔率模型
 */
public class FB_BqcInfo {
    private String id;
    private Object current_bqc;

    public FB_BqcInfo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getCurrent_bqc() {
        return current_bqc;
    }

    public void setCurrent_bqc(Object current_bqc) {
        this.current_bqc = current_bqc;
    }
}
