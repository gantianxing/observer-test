package com.sky.observer.controller;

import com.sky.observer.service.ConfigSubject;
import com.sky.observer.service.vo.ConfData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by gantianxing on 2017/10/9.
 */

@Controller
@RequestMapping("/")
public class TestController {

    @Resource
    private ConfigSubject subject;

    @RequestMapping("/")
    public String index() {
        return "forward:/hello";
    }

    @RequestMapping("/hello")
    public String hello(ConfData confData,Map<String,Object> map){
        if (confData == null || confData.getContent() == null){
            confData = new ConfData();
            confData.setContent("actMobConf=0\n\ractPcConf=0");
        }else{
            subject.notifyObervers(confData.getContent());//触发观察者方法调用
        }

        map.put("confData", confData);
        return "hello";
    }
}
