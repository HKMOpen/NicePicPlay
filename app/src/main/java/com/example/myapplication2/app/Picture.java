package com.example.myapplication2.app;

/**
 * Created by wangyuwei on 14-10-15.
 */
public class Picture {

    /**
     * 图片名称
     */
    private String name;

    /**
     * 图片对象的资源
     */
    private int resource;

    public Picture(String name, int resource) {
        this.name = name;
        this.resource = resource;
    }

    public String getName() {
        return name;
    }

    public int getResource() {
        return resource;
    }
}
