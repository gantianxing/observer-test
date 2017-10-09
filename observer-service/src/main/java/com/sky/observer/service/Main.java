package com.sky.observer.service;


import com.sky.observer.service.observer.ActMobRloadServiceImpl;
import com.sky.observer.service.observer.ActPcRloadServiceImpl;
import com.sky.observer.service.subject.ConfigSubjectImpl;

public class Main {

    public static void main(String[] args) {
        String conf = "actMobConf=1\r\nactPcConf=0";//模拟开关配置发生改变

        //step1 初始化主题和观察者，在spring中可以用spring ioc自动注入代替
        ConfigSubject subject = new ConfigSubjectImpl();//创建主题
        ConfigRloadService actMobRloadServiceImpl = new ActMobRloadServiceImpl(subject);//创建观察者
        ConfigRloadService actPcRloadServiceImpl = new ActPcRloadServiceImpl(subject);//创建观察者

        //step2 模拟开关配置改变，触发观察者reload方法
        subject.notifyObervers(conf);

    }
}
