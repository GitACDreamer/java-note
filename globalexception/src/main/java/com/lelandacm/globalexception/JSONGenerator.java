package com.lelandacm.globalexception;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright 2020. sunet corporation All rights reserved.
 * @web www.sunet.net.cn
 * @author LelandACM
 * @email lelandacm@sunet.net.cn
 * @date 2020/6/12 上午10:17
 */

/**
 * 生成json数据类
 */
@Component
public class JSONGenerator {
    public JSONG create() {
        return new JSONG();
    }

    public static class JSONG {
        private final Map<String, Object> json;
        private final Map<String, Object> data;

        public JSONG() {
            this.json = new HashMap<>();
            this.data = new HashMap<>();
        }

        public Map<String, Object> getJson() {
            return json;
        }

        public JSONG setStatus(int status) {
            json.put("status", status);
            return this;
        }

        public JSONG setMsg(String msg) {
            json.put("msg", msg);
            return this;
        }

        public JSONG setData(Object data) {
            json.put("data", data);
            return this;
        }

        public JSONG addKeyValue(String key, Object value) {
            json.put(key, value);
            return this;
        }

        public JSONG addToData(String key, Object value) {
            data.put(key, value);
            return this;
        }

        public JSONG addRootProperty(String key, Object value) {
            json.put(key, value);
            return this;
        }

        public String asJson() {
            if (data.size() > 0) {
                json.put("data", data);
            }
            return JSON.toJSONString(json, SerializerFeature.WriteDateUseDateFormat,
                    SerializerFeature.WriteNullNumberAsZero,
                    SerializerFeature.WriteNullStringAsEmpty,
                    SerializerFeature.WriteNullListAsEmpty);
        }

        public JSONObject asJsonObject() {
            if (data.size() > 0) {
                json.put("data", data);
            }
            return new JSONObject(json);
        }
    }

    /*获取多个对象多个指定参数的值
     * @description getMapList
     * @param list 对象列表
     * @param methodNameArray	需要的属性的get方法
     * @return
     */
    public static List<Map<String, Object>> getMapList(List<?> list, String... methodNameArray) {
        List<Map<String, Object>> maps = new ArrayList<>();

        for (Object entity : list) {
            Class<?> clazz = entity.getClass();

            Map<String, Object> map = new HashMap<>();
            for (String methodName : methodNameArray) {
                try {
                    Method method = clazz.getDeclaredMethod(methodName);
                    try {
                        Object result = method.invoke(entity);
                        String key = methodName;
                        if (key.indexOf("get") == 0 && key.length() > 3) {
                            key = String.valueOf(key.charAt(3)).toLowerCase() + key.substring(4);
                        }
                        map.put(key, result);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
            maps.add(map);
        }
        return maps;
    }
}
