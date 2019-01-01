package com.rscomponents.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("rscomponents.system")
public class  SystemConfiguration {
    private String selectedBrowser;
    private String browserFolder;
    public String getSelectedBrowser() {
        return selectedBrowser;
    }

    public String getBrowserFolder() {
        return browserFolder;
    }

    public void setBrowserFolder(String browserFolder) {
        this.browserFolder = browserFolder;
    }

    public void setSelectedBrowser(String selectedBrowser) {
        this.selectedBrowser = selectedBrowser;
    }
}
