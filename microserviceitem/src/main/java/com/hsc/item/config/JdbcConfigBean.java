package com.hsc.item.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class JdbcConfigBean {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    //@Value("${spring.datasource.driverClassName}")
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getDriverClassName() {
        return driverClassName;
    }
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
    @Override
    public String toString() {
        return "JdbcConfigBean [url=" + url + ", username=" + username
                + ", password=" + password + ", driverClassName="
                + driverClassName + "]";
    }
//    @Value("${spring.datasource.driver-class-name}")
    //@Value("${spring.datasource.username}")
    //@Value("${spring.datasource.url}")
   //@Value("${spring.datasource.password}")
    //@Value("${env}")
//    private String env;
//
//        public String getEnv() {
//        return env;
//    }
//    public void setEnv(String env) {
//        this.env = env;
//    }
//    @Override
//    public String toString() {
//        return "JdbcConfigBean [env=" + env + "]";
//    }
}
