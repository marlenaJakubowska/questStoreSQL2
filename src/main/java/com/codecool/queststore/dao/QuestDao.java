package com.codecool.queststore.dao;

import com.codecool.queststore.model.Quest;
import com.codecool.queststore.model.users.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestDao extends ConnectDao implements IQuestDao<Quest>{


    @Override
    public List<Quest> getAllQuests() {
        String query = "SELECT * FROM quests;";
        return createQuestsList(query);
    }

    private List<Quest> createQuestsList(String query) {
        List<Quest> quests = new ArrayList<>();
        try {
            connect();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int coins = rs.getInt("coins_to_earn");
                int moduleId = rs.getInt("module_id");
                String description = rs.getString("description");
                Quest quest = new Quest(id, name,  description, coins, moduleId);
                quests.add(quest);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quests;
    }

    @Override
    public Quest getById(int id) {
        return null;
    }

    @Override
    public void insert(Quest t) {

    }

    @Override
    public void update(Quest t) {

    }

    @Override
    public void delete(Quest t) {

    }
}
