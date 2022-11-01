package com.kerrrusha.playlistassistant.config;

import java.util.HashMap;

public class Config {

    private static Config instance;
    private HashMap<String, Object> config;
    
    private Config() {
        createConfig();
        initConfig();
    }

    private void createConfig() {
        config = new HashMap<>();
    }

    private void initConfig() {
        config.put("version", "1.0");
    }

    public static Config getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    private static void createInstance() {
        instance = new Config();
    }
    
    public Object getValue(String key) {
        return config.get(key);
    } 
}
