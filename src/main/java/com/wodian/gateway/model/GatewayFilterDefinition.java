package com.wodian.gateway.model;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * ProjectName:  gateway
 * Author:  yong.xu
 * Date:  2019/1/17  10:04
 * 创建过滤器定义模型
 */
public class GatewayFilterDefinition {
    //FilterName
    private String name;

    //对应的路由规则
    private Map<String,String> args=new LinkedHashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getArgs() {
        return args;
    }

    public void setArgs(Map<String, String> args) {
        this.args = args;
    }
}
