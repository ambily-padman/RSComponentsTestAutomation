package com.rscomponents.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("rscomponents.test")
public class TestConfiguration {
    private String url;
    private String name;
    private  String searchTestDataFile;
    private  String endToEndTestDataFile;
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSearchTestDataFile() {
        return searchTestDataFile;
    }

    public void setSearchTestDataFile(String searchTestDataFile) {
        this.searchTestDataFile = searchTestDataFile;
    }

    public String getEndToEndTestDataFile() {
        return endToEndTestDataFile;
    }

    public void setEndToEndTestDataFile(String endToEndTestDataFile) {
        this.endToEndTestDataFile = endToEndTestDataFile;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
