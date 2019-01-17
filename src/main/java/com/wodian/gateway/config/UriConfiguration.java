package com.wodian.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/*
 * ProjectName:  gateway
 * Author:  yong.xu
 * Date:  2019/1/11  15:25
 */
@ConfigurationProperties
public class UriConfiguration {
    private String httpbin = "http://httpbin.org:80";

    public String getHttpbin(){
        return httpbin;
    }

    public void setHttpbin(String httpbin){
        this.httpbin=httpbin;
    }
}
