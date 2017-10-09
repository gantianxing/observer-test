package com.sky.observer.service.observer;


import com.sky.observer.service.ConfigRloadService;
import com.sky.observer.service.ConfigSubject;
import com.sky.observer.service.SwitchEnum;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 观察者实现类1
 * Created by gantianxing on 2017/10/9.
 */
@Component
public class ActPcRloadServiceImpl implements ConfigRloadService {

    @Resource
    private ConfigSubject subject;

    public ActPcRloadServiceImpl(ConfigSubject subject){

        this.subject = subject;
        subject.registerObserver(SwitchEnum.actPcConf.name(),this);
    }

    @Override
    public void reload() {
        //查询数据库加载最新的配置内容到jvm内存，代码逻辑省略
        System.out.println("pc版活动配置reload");
    }

}
