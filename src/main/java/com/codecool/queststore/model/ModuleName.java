package com.codecool.queststore.model;

public enum ModuleName {
    PROGBASE("ProgBase"),
    JAVAOOP("JavaOOP"),
    WEBSQL("Web with SQL"),
    ADVANCED("Advanced");

    private final String description;

    ModuleName(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
