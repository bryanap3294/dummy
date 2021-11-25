package com.bryan.uploadfile.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
public class PropertiesConfig {

    @Value("${file.temp.path}")
    private String fileTempPath;

    public String getFileTempPath() {
        return fileTempPath;
    }

    public void setFileTempPath(String fileTempPath) {
        this.fileTempPath = fileTempPath;
    }
}
