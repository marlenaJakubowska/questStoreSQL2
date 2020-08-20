package com.codecool.queststore.model;

import java.util.HashMap;
import java.util.Map;

public enum ModuleName {
    PROGBASE(1),
    JAVAOOP(2),
    WEBSQL(3),
    ADVANCED(4);

    private final int moduleId;
    private static final Map<Integer, ModuleName> map = new HashMap<>();


    ModuleName(int moduleId) {
        this.moduleId = moduleId;
    }

    public int getModuleId() {
        return moduleId;
    }

    public static ModuleName valueOf(int moduleIdId) {
        for (ModuleName moduleName : ModuleName.values()) {
            map.put(moduleName.moduleId, moduleName);
        }
        return map.get(moduleIdId);
    }
}
