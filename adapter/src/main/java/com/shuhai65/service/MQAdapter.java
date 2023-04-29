package com.shuhai65.service;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 这个类⾥的⽅法⾮常᯿要，主要⽤于把不同类型MQ种的各种属性，映射成我们需要的属性并返
 * 回。就像⼀个属性中有 ⽤户ID;uId ，映射到我们需要的； userId ，做统⼀处理。
 * ⽽在这个处理过程中需要把映射管理传递给 Map<String, String> link ，也就是准确的描述
 * 了，当前MQ中某个属性名称，映射为我们的某个属性名称。
 * 最终因为我们接收到的 mq 消息基本都是 json 格式，可以转换为MAP结构。最后使⽤反射调⽤的
 * ⽅式给我们的类型赋值。
 */
public class MQAdapter {

    public static RebateInfo filter(String strJson, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return filter(JSON.parseObject(strJson, Map.class), link);
    }

    public static RebateInfo filter(Map obj, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RebateInfo rebateInfo = new RebateInfo();
        for (String key : link.keySet()) {
            Object val = obj.get(link.get(key));
            RebateInfo.class.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1), String.class).invoke(rebateInfo, val.toString());
        }
        return rebateInfo;
    }

}
