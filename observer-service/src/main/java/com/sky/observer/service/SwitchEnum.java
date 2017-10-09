package com.sky.observer.service;

/**
 * Created by gantianxing on 2017/10/9.
 */
public enum SwitchEnum {

    actMobConf(0),
    actPcConf(0);

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    SwitchEnum(int value){
        this.value = value;
    }


}
