package com.sky.observer.service.subject;



import com.sky.observer.service.ConfigRloadService;
import com.sky.observer.service.ConfigSubject;
import com.sky.observer.service.SwitchEnum;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gantianxing on 2017/10/9.
 */

@Component("subject")
public class ConfigSubjectImpl implements ConfigSubject {


    private Map<String,ConfigRloadService> observers = new HashMap();

    @Override
    public void registerObserver(String key,ConfigRloadService o) {
        observers.put(key, o);
    }

    @Override
    public void removeObserver(String key) {
        observers.remove(key);
    }

    /**
     * 通知对应的观察者
     * @param conf
     */
    @Override
    public void notifyObervers(String conf) {

        if(conf!=null && conf.length()>0){
            String [] configAray=conf.split("\\r\\n"); //回车换行做为配置分割，一行一个配置项
            for(String one:configAray){
                String [] oneArray = one.split("=");

                if(oneArray.length !=2){
                    continue;
                }

                String key = oneArray[0];
                String value = oneArray[1];

                int iv_new = Integer.parseInt(value);
                int iv_old = SwitchEnum.valueOf(key).getValue();

                if(iv_new != iv_old){//如果配置开关不相等，说明配置内容已经更改，需要重新reload数据
                    ConfigRloadService service = observers.get(key);
                    if(service != null){
                        service.reload();
                    }
                    SwitchEnum.valueOf(key).setValue(iv_new);
                }

            }

        }



    }
}
