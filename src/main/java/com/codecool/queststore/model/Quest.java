package com.codecool.queststore.model;

public class Quest {
    private int id;
    private String name;
    private int coinsToEarn;
    private int moduleId;
    private String description;

    public Quest(int id, String name, String description, int coinsToEarn, int moduleId) {
        this.id = id;
        this.name = name;
        this.coinsToEarn = coinsToEarn;
        this.moduleId = moduleId;
        this.description = description;
    }

    public Quest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoinsToEarn() {
        return coinsToEarn;
    }

    public void setCoinsToEarn(int coinsToEarn) {
        this.coinsToEarn = coinsToEarn;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Quest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coinsToEarn=" + coinsToEarn +
                ", moduleId=" + moduleId +
                ", description='" + description + '\'' +
                '}';
    }
}
