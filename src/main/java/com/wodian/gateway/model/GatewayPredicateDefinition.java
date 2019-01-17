package com.wodian.gateway.model;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * ProjectName:  gateway
 * Author:  yong.xu
 * Date:  2019/1/17  10:08
 * 路由断言定义模型
 */
public class GatewayPredicateDefinition {

    //断言对应的name
    private String name;

    //配置的断言规则
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
