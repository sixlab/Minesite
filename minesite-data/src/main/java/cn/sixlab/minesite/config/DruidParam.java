package cn.sixlab.minesite.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "spring")
public class DruidParam {
    private Map<String, String> datasource = new HashMap<>();
    
    public Map<String, String> getDatasource() {
        return datasource;
    }
    
    public void setDatasource(Map<String, String> datasource) {
        this.datasource = datasource;
    }
}
