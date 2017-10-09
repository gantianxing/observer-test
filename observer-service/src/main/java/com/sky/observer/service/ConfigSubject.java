package com.sky.observer.service;

/**
 * Created by gantianxing on 2017/10/9.
 */
public interface ConfigSubject {
    void registerObserver(String key, ConfigRloadService o);//注册观察者
    void removeObserver(String key);//删除观察者
    void notifyObervers(String conf);//通知观察者
}
