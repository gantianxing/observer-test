package com.sky.observer.service.observer;


import com.sky.observer.service.ConfigRloadService;
import com.sky.observer.service.ConfigSubject;
import com.sky.observer.service.SwitchEnum;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 观察者实现类2
 * Created by gantianxing on 2017/10/9.
 */

@Component
public class ActMobRloadServiceImpl implements ConfigRloadService {

    @Resource
    private ConfigSubject subject;

    public ActMobRloadServiceImpl(ConfigSubject subject){

        this.subject = subject;
        subject.registerObserver(SwitchEnum.actMobConf.name(),this);
    }

    @Override
    public void reload() {

        //查询数据库加载最新的配置内容到jvm内存，代码逻辑省略
        System.out.println("移动端活动配置reload");
    }
}
