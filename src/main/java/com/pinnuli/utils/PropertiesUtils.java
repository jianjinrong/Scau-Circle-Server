package com.pinnuli.utils;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

/**
 * @description: 描述
 * @author: pinnuli
 * @date: 2018-09-05
 */

public class PropertiesUtils {

    public String getUrlValue(String urlName,String properName) {
        String url = null;
        Properties prop = new Properties();
        try {
            ClassLoader classLoader = PropertiesUtils.class.getClassLoader();// 读取属性文件xxxxx.properties
            InputStream in = classLoader.getResourceAsStream(properName+".properties");
            prop.load(in); /// 加载属性列表
            Iterator<String> it = prop.stringPropertyNames().iterator();
            while (it.hasNext()) {
                if (it.next().equals(urlName)) {
                    url = prop.getProperty(urlName);
                }
            }
            in.close();
        } catch (Exception e) {

        }
        return url;
    }
}
