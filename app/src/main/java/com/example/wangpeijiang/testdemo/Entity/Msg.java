package com.example.wangpeijiang.testdemo.Entity;

/**
 * Created by wangpeijiang on 2018/3/14.
 */

public class Msg {
    public static  final  int TYPE_RECEIVER = 0;
    public static  final  int TYPE_SENT = 1;



    private String content;
    private int type;

    public Msg(String content,int type){
        this.content = content;
        this.type = type;
    }
    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
